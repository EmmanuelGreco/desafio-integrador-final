$(document).ready(function() {
    let page = 0;

    function loadMovies(page) {
        $.ajax({
            url: `/api/peliculas?page=${page}`,
            method: 'GET',
            success: function(data) {
                data.forEach(function(movie) {
                    const movieCard = `
                        <div class="col-md-4 mb-4">
                            <div class="card">
                                <img src="${movie.portada}" class="card-img-top" alt="${movie.titulo}">
                                <div class="card-body">
                                    <h5 class="card-title">${movie.titulo}</h5>
                                    <p class="card-text">${movie.director}</p>
                                    <button class="btn btn-primary btn-detail" data-id="${movie.id}">Detalle</button>
                                </div>
                            </div>
                        </div>
                    `;
                    $('#movieContainer').append(movieCard);
                });
            },
            error: function(xhr, status, error) {
                console.error('Error al cargar las películas:', error);
            }
        });
    }

    function loadMovieDetail(id) {
        $.ajax({
            url: `/api/peliculas/${id}`,
            method: 'GET',
            success: function(movie) {
                const movieDetail = `
                    <div class="text-center">
                        <img src="${movie.portada}" alt="${movie.titulo}" class="img-fluid">
                    </div>
                    <h2>${movie.titulo}</h2>
                    <p>Director: ${movie.director}</p>
                    <p>URL: <a href="${movie.url}" target="_blank">${movie.url}</a></p>
                    <p>Precio: ${movie.precio}</p>
                `;
                $('#movieDetailContent').html(movieDetail);
                $('#movieDetailModal').modal('show');
            },
            error: function(xhr, status, error) {
                console.error('Error al cargar el detalle de la película:', error);
            }
        });
    }

    // Cargar películas al hacer scroll
    $(window).on('scroll', function() {
        if ($(window).scrollTop() + $(window).height() >= $(document).height() - 100) {
            page++;
            loadMovies(page);
        }
    });

    // Inicialmente cargar la primera página de películas
    loadMovies(page);

    $('#searchButton').click(function() {
        const query = $('#searchInput').val();
        $.ajax({
            url: `/api/peliculas/search?query=${query}`,
            method: 'GET',
            success: function(data) {
                $('#movieContainer').empty();
                data.forEach(function(movie) {
                    const movieCard = `
                        <div class="col-md-4 mb-4">
                            <div class="card">
                                <img src="${movie.portada}" class="card-img-top" alt="${movie.titulo}">
                                <div class="card-body">
                                    <h5 class="card-title">${movie.titulo}</h5>
                                    <p class="card-text">${movie.director}</p>
                                    <button class="btn btn-primary btn-detail" data-id="${movie.id}">Detalle</button>
                                </div>
                            </div>
                        </div>
                    `;
                    $('#movieContainer').append(movieCard);
                });
            },
            error: function(xhr, status, error) {
                console.error('Error al buscar las películas:', error);
            }
        });
    });

    $(document).on('click', '.btn-detail', function() {
	    const id = $(this).data('id');
	    console.log('Detalle de película ID:', id); // Verifica que el ID es correcto
	    loadMovieDetail(id);
	});
});
