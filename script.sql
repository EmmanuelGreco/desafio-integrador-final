CREATE DATABASE IF NOT EXISTS desafio_integrador_final;
USE desafio_integrador_final;

INSERT INTO peliculas (`id`, `titulo`, `director`, `url`, `portada`, `precio`)
VALUES
(1, 'Oppenheimer', 'Christopher Nolan', 'https://www.uphe.com/movies/oppenheimer', 'https://dx35vtwkllhj9.cloudfront.net/universalstudios/oppenheimer-watch/images/regions/us/onesheet.jpg', '63999.99'),
(2, 'Inception', 'Christopher Nolan', 'https://www.warnerbros.com/movies/inception', 'https://irs.www.warnerbros.com/gallery-v2-jpeg/inception_posterlarge_1-1113180550.jpg', '53999.99'),
(3, 'Interstellar', 'Christopher Nolan', 'https://www.warnerbros.co.uk/movies/interstellar', 'https://d5d5yejrba9lo.cloudfront.net/keyart-jpeg/movies/media/browser/interstellar_v_dd_ka_tt_cvrart_2000x3000_300dpi_en_3742435d.jpeg', '58999.99'),
(4, 'Dunkirk', 'Christopher Nolan', 'https://www.warnerbros.com/movies/dunkirk', 'https://irs.www.warnerbros.com/keyart-jpeg/movies/media/browser/dunkirk_keyart_whv_0.jpg', '49999.99'),
(5, 'Tenet', 'Christopher Nolan', 'https://www.warnerbros.com/movies/tenet', 'https://irs.www.warnerbros.com/keyart-jpeg/movies/media/browser/tenet_textless_2000x3000.jpg', '47999.99'),
(6, 'Memento', 'Christopher Nolan', 'https://www.imdb.com/title/tt0209144/', 'https://m.media-amazon.com/images/M/MV5BY2Q5YWE0ZTktYTAzNC00ZTkyLWFjYWItNTA3NmZhMjRmODY5XkEyXkFqcGdeQXVyMTAzMDM4MjM0._V1_.jpg', '54999.99'),
(7, 'The Prestige', 'Christopher Nolan', 'https://www.warnerbros.co.uk/movies/prestige', 'https://d5d5yejrba9lo.cloudfront.net/keyart-jpeg/movies/batch/sid_D0C10B1B-96D8-450D-A1A0-A8ED1FD93BE6.jpg', '59999.99'),
(8, 'Batman: Begins', 'Christopher Nolan', 'https://www.warnerbros.com/movies/batman-begins', 'https://irs.www.warnerbros.com/keyart-jpeg/movies/media/browser/batman_begins_key_art.jpeg', '55999.99'),
(9, 'Batman: The Dark Knight', 'Christopher Nolan', 'https://www.warnerbros.com/movies/dark-knight', 'https://irs.www.warnerbros.com/keyart-jpeg/movies/media/browser/the_dark_knight_key_art.jpg', '58999.99'),
(10, 'Batman: The Dark Knight Rises', 'Christopher Nolan', 'https://www.warnerbros.com/movies/dark-knight-rises', 'https://irs.www.warnerbros.com/keyart-jpeg/movies/media/browser/the_dark_knight_rises_key_art.jpg', '61999.99'),
(11, 'Prisoners', 'Denis Villeneuve', 'https://www.warnerbros.com/movies/prisoners', 'https://irs.www.warnerbros.com/keyart-jpeg/prisoners_keyart.jpg', '51999.99'),
(12, 'Arrival', 'Denis Villeneuve', 'https://www.imdb.com/title/tt2543164/', 'https://m.media-amazon.com/images/M/MV5BODQxMTg1NTItNWFjMi00NmQ4LWIzYmUtNWVlNTNlZTczNDMzXkEyXkFqcGdeQXVyMTMzODk3NDU0._V1_FMjpg_UY485_.jpg', '52999.99'),
(13, 'Blade Runner 2049', 'Denis Villeneuve', 'https://www.bladerunner2049movie.com/', 'https://image.tmdb.org/t/p/original/2bw31VZOMiiUnay1CPwlDQBZvGK.jpg', '57999.99'),
(14, 'Enemy', 'Denis Villeneuve', 'https://www.imdb.com/title/tt2316411/', 'https://m.media-amazon.com/images/M/MV5BMTQ2NzA5NjE4N15BMl5BanBnXkFtZTgwMjQ4NzMxMTE@._V1_FMjpg_UY706_.jpg', '41999.99'),
(15, 'Transcendence', 'Wally Pfister', 'https://www.warnerbros.com/movies/transcendence', 'https://irs.www.warnerbros.com/keyart-jpeg/transcendence_keyart_0.jpg', '42999.99'),
(16, 'The Little Things', 'John Lee Hancock', 'https://www.warnerbros.com/movies/little-things', 'https://irs.www.warnerbros.com/keyart-jpeg/movies/media/browser/the_little_things_2000x3000_v2.jpg', '44999.99'),
(17, 'A Monster Calls', 'Juan Antonio Bayona', 'https://www.uphe.com/movies/a-monster-calls', 'https://www.uphe.com/sites/default/files/styles/scale__344w_/public/AMonsterCalls_PosterArt.jpg?itok=KVIzgLQ6', '47999.99'),
(18, 'The Whale', 'Darren Aronofsky', 'https://www.imdb.com/title/tt13833688/', 'https://m.media-amazon.com/images/M/MV5BZDQ4Njg4YTctNGZkYi00NWU1LWI4OTYtNmNjOWMyMjI1NWYzXkEyXkFqcGdeQXVyMTA3MDk2NDg2._V1_FMjpg_UY720_.jpg', '51999.99'),
(19, 'The Shape Of Water', 'Guillermo del Toro', 'https://www.20thcenturystudios.com/movies/the-shape-of-water', 'https://lumiere-a.akamaihd.net/v1/images/shapeofwater_feature-poster_584x800_c53863cc.jpeg?region=0%2C0%2C584%2C800', '38999.99'),
(20, 'Poor Things', 'Yorgos Lanthimos', 'https://www.searchlightpictures.com/poor-things', 'https://searchlight-studio-2023-prod.s3.amazonaws.com/assets/film/poor-things/_icon/PT_Payoff_ONLINE_POSTER_1350x2000_FIN.jpg', '39999.99'),
(21, 'The Mummy', 'Stephen Sommers', 'https://www.uphe.com/movies/the-mummy-1999', 'https://www.uphe.com/sites/default/files/styles/scale__344w_/public/Mummy_PosterArt_0.jpg', '37999.99'),
(22, 'The Mummy Returns', 'Stephen Sommers', 'https://www.uphe.com/movies/the-mummy-returns', 'https://www.uphe.com/sites/default/files/styles/scale__344w_/public/MummyReturns_PosterArt.jpg', '38999.99'),
(23, 'The Mummy III', 'Rob Cohen', 'https://www.uphe.com/movies/the-mummy-tomb-of-the-dragon-emperor', 'https://www.uphe.com/sites/default/files/styles/scale__344w_/public/MummyTombDragonEmperor_PosterArt.jpg', '35999.99'),
(24, 'Barbie', 'Greta Gerwig', 'https://www.warnerbros.com/movies/barbie', 'https://irs.www.warnerbros.com/keyart-jpeg/movies/media/browser/barbie_keyart_0.jpg', '42999.99'),
(25, 'The Avengers', 'Joss Whedon', 'https://www.marvel.com/movies/the-avengers', 'https://cdn.marvel.com/content/1x/theavengers_lob_crd_03_0.jpg', '62999.99'),
(26, 'Avengers: Age of Ultron', 'Joss Whedon', 'https://www.marvel.com/movies/avengers-age-of-ultron', 'https://cdn.marvel.com/content/1x/avengersageofultron_lob_crd_03_0.jpg', '62999.99'),
(27, 'Avengers: Infinity War', 'Russo brothers', 'https://www.marvel.com/movies/avengers-infinity-war', 'https://cdn.marvel.com/content/1x/avengersinfinitywar_lob_crd_02.jpg', '63999.99'),
(28, 'Avengers: Endgame', 'Russo brothers', 'https://www.marvel.com/movies/avengers-endgame', 'https://cdn.marvel.com/content/1x/avengersendgame_lob_crd_05.jpg', '63999.99'),
(29, 'La La Land', 'Damien Chazelle', 'https://www.lionsgate.com/movies/la-la-land', 'https://lionsgate.brightspotcdn.com/bf/d2/306cfd60415fa6f98f9f1280a3dd/lalaland-movies-he-poster-01.jpg', '47999.99'),
(30, 'The Notebook', 'Nick Cassavetes', 'https://www.warnerbros.com/movies/notebook', 'https://irs.www.warnerbros.com/keyart-jpeg/movies/media/browser/the_notebook_key_art.jpg', '33999.99');

INSERT INTO generos (`id`, `nombre`)
VALUES
(1, 'Suspenso'),
(2, 'Ciencia ficción'),
(3, 'Acción'),
(4, 'Aventura'),
(5, 'Misterio'),
(6, 'Crimen'),
(7, 'Terror'),
(8, 'Fantasía'),
(9, 'Infantil'),
(10, 'Drama'),
(11, 'Romance'),
(12, 'Comedia'),
(13, 'Musical'),
(14, 'Bélico'),
(15, 'Época/Historia');

INSERT INTO peliculas_generos (`pelicula_id`, `genero_id`)
VALUES
(1, 1),(1, 14),(1, 15),
(2, 2),(2, 3),(2, 1),
(3, 2),(3, 4),(3, 1),
(4, 3),(4, 14),(4, 15),
(5, 3),(5, 2),
(6, 1),(6, 5),(6, 6),
(7, 1),(7, 10),
(8, 1),(8, 3),(8, 4),
(9, 1),(9, 3),(9, 4),(9, 10),
(10, 1),(10, 3),(10, 4),
(11, 1),(11, 5),(11, 6),(11, 10),
(12, 10),(12, 2),(12, 5),
(13, 2),(13, 8),(13, 1),
(14, 10),(14, 5),
(15, 8),(15, 10),(15, 2),(15, 1),
(16, 1),(16, 5),(16, 6),(16, 10),
(17, 8),(17, 9),
(18, 10),
(19, 10),(19, 8),(19, 11),
(20, 12),(20, 11),(20, 10),
(21, 3),(21, 4),(21, 8),
(22, 3),(22, 4),(22, 8),
(23, 3),(23, 4),(23, 8),
(24, 12),(24, 8),
(25, 3),(25, 2),(25, 8),
(26, 3),(26, 2),(26, 8),
(27, 3),(27, 2),(27, 8),
(28, 3),(28, 2),(28, 8),
(29, 10),(29, 11),(29, 12),(29, 13),
(30, 11),(30, 10);

INSERT INTO roles (`id`, `name`)
VALUES
('1', 'ROLE_ADMIN'),
('2', 'ROLE_SOCIO');

INSERT INTO users (`id`, `email`, `name`, `password`, `activo`, `fecha_alta`) 
VALUES 
('1', 'admin@pelisflix.com', 'Admin1', '$2a$10$wKSzhjPWxkyPpAGjbgUVQe56xGXXd1wq7o..k5d.xj49I7Gs7zOze', true, CURRENT_DATE),
('2', 'socio@pelisflix.com', 'Socio1', '$2a$10$JuIEIvSypMDXOtx54igbNuxFr.fnXUwr5noCjS2pPxWXQRCtYkUWa', true, CURRENT_DATE);

INSERT INTO users_roles (`user_id`, `role_id`)
VALUES (
    (SELECT id FROM users WHERE `email` = 'admin@pelisflix.com'),
    (SELECT id FROM roles WHERE `name` = 'ROLE_ADMIN')
);

INSERT INTO users_roles (`user_id`, `role_id`)
VALUES (
    (SELECT id FROM users WHERE `email` = 'socio@pelisflix.com'),
    (SELECT id FROM roles WHERE `name` = 'ROLE_SOCIO')
);

INSERT INTO cupones (`id`, `name`, `descuento`)
VALUES 
('1', 'DESC10', 10.0),
('2', 'DESC20', 20.0),
('3', 'DESC30', 30.0);

INSERT INTO estados_ordenes (`id`, `name`)
VALUES
('1', 'Pagado'),
('2', 'Pendiente de pago'),
('3', 'Cancelado'),
('4', 'Rechazado');

-- Ejemplo de orden
INSERT INTO ordenes (`id`, `fecha_creacion`, `socio_id`, `estado_orden_id`, `pelicula_id`, `monto_total`)
VALUES (
	'1',
    CURRENT_DATE,
    (SELECT id FROM users WHERE email = 'socio@pelisflix.com'),
    (SELECT id FROM estados_ordenes WHERE name = 'Pagado'),
    1,
    (SELECT precio FROM peliculas WHERE id = 1)
);
    
-- Ejemplo de orden con cupón
INSERT INTO ordenes (`id`, `fecha_creacion`, `socio_id`, `estado_orden_id`, `cupon_id`, `pelicula_id`, `monto_total`)
VALUES (
	'2',
    CURRENT_DATE,
    (SELECT id FROM users WHERE email = 'socio@pelisflix.com'),
    (SELECT id FROM estados_ordenes WHERE name = 'Rechazado'),
    (SELECT id FROM cupones WHERE name = 'DESC10'),
    2,
    ROUND(
		(SELECT precio * (1 - (SELECT descuento FROM cupones WHERE name = 'DESC10') / 100) FROM peliculas WHERE id = 1),
	2)
);
