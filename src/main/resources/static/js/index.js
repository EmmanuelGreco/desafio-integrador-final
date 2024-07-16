let currentPage = 1;
let query = '';
let isFetching = false;
let allMoviesLoaded = false;
const batchSize = 8; // Cargar 8 películas a la vez
const loadedMovies = new Set();
const moviesContainer = document.getElementById('movies-container');

document.addEventListener('DOMContentLoaded', function() {
	loadMovies(`/api/peliculas?page=${currentPage}&size=${batchSize}`);

	document.getElementById('search').addEventListener('input', function(event) {
		query = event.target.value.trim();
		currentPage = 1;
		allMoviesLoaded = false;
		loadedMovies.clear();
		moviesContainer.innerHTML = '';
		loadMovies(getMoviesUrl());
	});

	window.addEventListener('scroll', handleScroll);

	document.getElementById('logoutButton').addEventListener('click', logout);

});

function handleScroll() {
	if (!allMoviesLoaded && !isFetching && isNearBottom()) {
		currentPage++;
		isFetching = true;
		loadMovies(getMoviesUrl());
	}
}

function getMoviesUrl() {
	if (query) {
		return `/api/peliculas/search?titulo=${encodeURIComponent(query)}&page=${currentPage}&size=${batchSize}`;
	} else {
		return `/api/peliculas?page=${currentPage}&size=${batchSize}`;
	}
}

function isNearBottom() {
	const moviesContainerHeight = moviesContainer.offsetHeight;
	const scrollY = window.scrollY;
	const windowInnerHeight = window.innerHeight;
	const threshold = 50;

	return windowInnerHeight + scrollY >= moviesContainerHeight - threshold;
}

function loadMovies(url) {
	fetch(url)
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.json();
		})
		.then(data => {
			handleMoviesData(data);
		})
		.catch(error => {
			console.error('Error fetching movies:', error);
			isFetching = false;
		});
}

function handleMoviesData(data) {
	if (!data || data.length === 0) {
		allMoviesLoaded = true;
		isFetching = false;
		return;
	}

	let loadedCount = 0;
	data.forEach(pelicula => {
		if (!loadedMovies.has(pelicula.id) && loadedCount < batchSize) {
			loadedMovies.add(pelicula.id);
			moviesContainer.insertAdjacentHTML('beforeend', generateMovieCard(pelicula));
			loadedCount++;
		}
	});

	if (loadedCount < batchSize) {
		allMoviesLoaded = true;
	}

	isFetching = false;
}

function generateMovieCard(pelicula) {
	let generosHTML = '';
	if (pelicula.generos) {
		pelicula.generos.forEach(genero => {
			generosHTML += `<span class="badge badge-secondary">${genero.nombre}</span> `;
		});
	}

	return `
        <div class="col-md-3 mb-4">
            <div class="card" onmouseover="showDetail(this)" onmouseout="hideDetail(this)">
                <img src="${pelicula.portada}" class="card-img-top" alt="${pelicula.titulo}">
                <div class="card-body">
                    <h6 class="card-title">${pelicula.titulo}</h6>
                    <h6 class="card-precio">$ ${pelicula.precio}</h6>
                </div>
                <div class="detail-card">
                    <h3>${pelicula.titulo}</h3>
                    <div class="generos-list">
                        ${generosHTML}
                    </div>
                    <p>Director: ${pelicula.director}</p>
                    <p>Sitio web oficial: <a href="${pelicula.url}" target="_blank">${pelicula.url}</a></p>                            
                    <p>Precio: $ ${pelicula.precio}</p>
                    <button class="btn btn-comprar">Comprar</button>
                </div>
            </div>
        </div>
    `;
}

function showDetail(card) {
	const detailCard = card.querySelector('.detail-card');
	detailCard.style.display = 'block';
}

function hideDetail(card) {
	const detailCard = card.querySelector('.detail-card');
	detailCard.style.display = 'none';
}

function logout() {
	fetch('/auth/logout', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		}
	})
		.then(response => {
			if (response.ok) {
				window.location.href = '/login';
			} else {
				console.error('Error al cerrar sesión');
			}
		})
		.catch(error => console.error('Error al cerrar sesión:', error));
}
