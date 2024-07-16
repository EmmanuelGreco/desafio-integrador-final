let currentPage = 1;
let query = '';
let isFetching = false;
let allMoviesLoaded = false;
const batchSize = 8; // Cargar 8 películas a la vez

// Set para evitar películas duplicadas
const loadedMovies = new Set();

document.addEventListener('DOMContentLoaded', function() {
	const moviesContainer = document.getElementById('movies-container');

	loadMovies(`/api/peliculas?page=${currentPage}&size=${batchSize}`);

	document.getElementById('search').addEventListener('input', function(event) {
		query = event.target.value.trim();
		currentPage = 1;
		allMoviesLoaded = false;
		loadedMovies.clear();
		moviesContainer.innerHTML = '';
		if (query) {
			loadMovies(`/api/peliculas/search?titulo=${encodeURIComponent(query)}&page=${currentPage}&size=${batchSize}`);
		} else {
			loadMovies(`/api/peliculas?page=${currentPage}&size=${batchSize}`);
		}
	});

	window.addEventListener('scroll', function() {
		const moviesLoaded = document.querySelectorAll('#movies-container .card').length;
		const moviesContainerHeight = moviesContainer.offsetHeight;
		const scrollY = window.scrollY;
		const windowInnerHeight = window.innerHeight;

		if (!allMoviesLoaded && !isFetching && (windowInnerHeight + scrollY >= moviesContainerHeight - 100)) {
			currentPage++;
			isFetching = true;
			if (query) {
				loadMovies(`/api/peliculas/search?titulo=${encodeURIComponent(query)}&page=${currentPage}&size=${batchSize}`);
			} else {
				loadMovies(`/api/peliculas?page=${currentPage}&size=${batchSize}`);
			}
		}
	});
});

function loadMovies(url) {
	fetch(url)
		.then(response => response.json())
		.then(data => {
			const moviesContainer = document.getElementById('movies-container');
			if (data.length === 0) {
				allMoviesLoaded = true;
			} else {
				let loadedCount = 0;

				data.forEach(pelicula => {
					if (!loadedMovies.has(pelicula.id) && loadedCount < batchSize) {
						loadedMovies.add(pelicula.id);
						const movieCard = `
                                <div class="col-md-3 mb-4">
                            		<div class="card" onmouseover="showDetail(this)" onmouseout="hideDetail(this)">
                                        <img src="${pelicula.portada}" class="card-img-top" alt="${pelicula.titulo}">
                                        <div class="card-body">
                                            <h6 class="card-title">${pelicula.titulo}</h6>
                                            <h6 class="card-precio">$ ${pelicula.precio}</h6>
                                        </div>
                                        <div class="detail-card">
	                                        <h5>${pelicula.titulo}</h5>
	                                        <p>Director: ${pelicula.director}</p>
	                                        <p>Sitio web oficial: <a href="${pelicula.url}" target="_blank">${pelicula.url}</a></p>
	                                        <button class="btn btn-comprar">Comprar</button>
                                    	</div>
                                    </div>
                                </div>
                            `;
						moviesContainer.insertAdjacentHTML('beforeend', movieCard);
						loadedCount++;
					}
				});

				if (loadedCount < batchSize) {
					allMoviesLoaded = true;
				}
			}
			isFetching = false;
		})
		.catch(error => {
			console.error('Error fetching movies:', error);
			isFetching = false;
		});
}

function showDetail(card) {
	const detailCard = card.querySelector('.detail-card');
	detailCard.style.display = 'block';
}

function hideDetail(card) {
	const detailCard = card.querySelector('.detail-card');
	detailCard.style.display = 'none';
}
