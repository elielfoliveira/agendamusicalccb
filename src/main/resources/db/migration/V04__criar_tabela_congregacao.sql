CREATE TABLE congregacao (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    endereco VARCHAR(80) NOT NULL,
    numero INT(6) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cep VARCHAR(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;GINE=InnoDB DEFAULT CHARSET=utf8;