insert into categoria (id, nome, descricao) values
   (1, 'INFORMATICA','produtos de informática'),
   (2, 'ESCRITORIO','cadeiras, mesas, e materiais de escritório'),
   (3, 'LIVRARIA','livros, revistas, quadrinhos');
   
insert into produto (id, nome, descricao, qtd_estoque, valor, id_categoria, data_fabricacao) values
   (1, 'Cadeira bx9',             'cadeira ergonomica confortavel',   3 ,  850.00, 2, '2019-10-01'),
   (2, 'Escrivaniha 1000',        'escrivainha para computador',      4 , 1850.00, 2, '2019-08-11'),
   (3, 'Do Inferno',              'Quadrinho do Alan More',           2 ,  150.00, 3, '2017-12-21'),
   (4, 'Use a Cabeca Java',       'Livro principal para Java',       10 ,  75.00,  3, '2016-04-22'),
   (5, 'Tablet Samsung',          'Tablet 10 polegadas',              2 , 3850.00, 1, '2018-02-04'),
   (6, 'Mouse Logitec',           'Mouse com 3 botoes e uma rodinha', 2 ,   50.00, 1, '2019-07-13'),
   (7, 'Fita Crepe',              'Fita crepe simples',              33 ,    1.30, 2, '2012-12-15'),
   (8, 'Mousepad',                'Mousepad estilizado com foto',    13 ,   25.00, 1, '2020-01-04'),
   (9, 'A Batalha do Apocalipse', 'Melhor livro que voce deve ler',  42 ,   55.00, 3, '2009-01-21');
   
