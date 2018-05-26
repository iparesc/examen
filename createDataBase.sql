CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO usuario (nombre,password) values ('javier',1986);
INSERT INTO usuario (nombre,password) values ('inaxio',1984);


CREATE TABLE `guardarConsultas` (
  `nombre` varchar(50) NOT NULL,
  `busqueda` varchar(50) DEFAULT '0',
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `id_idx` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;