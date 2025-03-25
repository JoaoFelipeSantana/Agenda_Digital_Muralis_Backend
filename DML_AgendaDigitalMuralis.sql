USE comercioSA;

-- Inserindo clientes
INSERT INTO cliente (nome, cpf, dt_nascimento) VALUES
('João Silva', '12345678901', '1990-05-15'),
('Maria Oliveira', '98765432100', '1985-08-22'),
('Carlos Souza', '45678912345', '2000-12-10'),
('Ana Costa', '32165498700', '1995-04-05');

-- Inserindo endereços
INSERT INTO endereco (cep, logadouro, bairro, cidade, estado) VALUES
('01001000', 'Avenida Paulista', 'Bela Vista', 'São Paulo', 'SP'),
('22041001', 'Rua Barata Ribeiro', 'Copacabana', 'Rio de Janeiro', 'RJ'),
('30130010', 'Rua da Bahia', 'Centro', 'Belo Horizonte', 'MG'),
('40020000', 'Avenida Sete de Setembro', 'Centro', 'Salvador', 'BA');

-- Relacionando clientes aos endereços
INSERT INTO cliente_endereco (id_cliente, id_endereco, numero) VALUES
(1, 1, 100),
(2, 2, 200),
(3, 3, 300),
(4, 4, 400);

-- Inserindo contatos
INSERT INTO contato (id_cliente, tipo, valor, observacao) VALUES
(1, 'email', 'joao.silva@email.com', 'E-mail pessoal'),
(1, 'telefone', '11987654321', 'WhatsApp'),
(2, 'email', 'maria.oliveira@email.com', 'E-mail profissional'),
(2, 'telefone', '21987654321', 'Telefone residencial'),
(3, 'email', 'carlos.souza@email.com', 'Contato principal'),
(3, 'telefone', '31987654321', 'Telefone comercial'),
(4, 'email', 'ana.costa@email.com', 'Contato pessoal'),
(4, 'telefone', '71987654321', 'Telefone fixo');
