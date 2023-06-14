CREATE TABLE `tipo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8

CREATE TABLE `participante` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idcongregacao` bigint(20) DEFAULT NULL,
  `idinstrumento` bigint(20) DEFAULT NULL,
  `idtipo` bigint(20) DEFAULT NULL,
  `nome` varchar(80) NOT NULL,
  `dtnascimento` date DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `dtcadastro` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `congregacao_ibfk_1` (`idcongregacao`),
  KEY `instrumento_ibfk_2` (`idinstrumento`),
  KEY `tipo_ibfk_3` (`idtipo`),
  CONSTRAINT `congregacao_ibfk_1` FOREIGN KEY (`idcongregacao`) REFERENCES `congregacao` (`id`),
  CONSTRAINT `instrumento_ibfk_2` FOREIGN KEY (`idinstrumento`) REFERENCES `instrumento` (`id`),
  CONSTRAINT `tipo_ibfk_3` FOREIGN KEY (`idtipo`) REFERENCES `tipo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8TO_INCREMENT=15 DEFAULT CHARSET=utf8O_INCREMENT=4 DEFAULT CHARSET=utf8