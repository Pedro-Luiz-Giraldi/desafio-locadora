-- Insert default Cliente data
INSERT INTO cliente (nome, email) VALUES ('João Silva', 'joao@email.com');
INSERT INTO cliente (nome, email) VALUES ('Maria Santos', 'maria@email.com');
INSERT INTO cliente (nome, email) VALUES ('Pedro Oliveira', 'pedro@email.com');

-- Insert default Filme data
INSERT INTO filme (titulo, genero, diretor) VALUES ('O Senhor dos Anéis', 'Fantasia', 'Peter Jackson');
INSERT INTO filme (titulo, genero, diretor) VALUES ('Interestelar', 'Ficção Científica', 'Christopher Nolan');
INSERT INTO filme (titulo, genero, diretor) VALUES ('Inception', 'Ficção Científica', 'Christopher Nolan');
INSERT INTO filme (titulo, genero, diretor) VALUES ('Matrix', 'Ficção Científica', 'Wachowski');
INSERT INTO filme (titulo, genero, diretor) VALUES ('Titanic', 'Drama', 'James Cameron');

-- Insert default Locacao data
-- INSERT INTO locacao (cliente_id, filme_id, data_locacao, data_devolucao_prevista, devolvido, data_devolucao)
-- VALUES (1, 1, '2026-05-01', '2026-05-08', false, null);
-- INSERT INTO locacao (cliente_id, filme_id, data_locacao, data_devolucao_prevista, devolvido, data_devolucao)
-- VALUES (2, 2, '2026-05-02', '2026-05-09', true, '2026-05-08');
-- INSERT INTO locacao (cliente_id, filme_id, data_locacao, data_devolucao_prevista, devolvido, data_devolucao)
-- VALUES (3, 3, '2026-05-03', '2026-05-10', false, null);