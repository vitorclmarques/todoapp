-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10/08/2023 às 17:29
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `todoapp`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `projects`
--

CREATE TABLE `projects` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `projects`
--

INSERT INTO `projects` (`id`, `name`, `description`, `createdAt`, `updatedAt`) VALUES
(4, 'Meu primeiro projeto ', 'Teste?para o app Todo App', '2023-08-09 00:00:00', '2023-08-09 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tasks`
--

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL,
  `idProject` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `completed` tinyint(1) NOT NULL,
  `deadline` date NOT NULL,
  `creatAt` datetime NOT NULL,
  `updateAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tasks`
--

INSERT INTO `tasks` (`id`, `idProject`, `name`, `description`, `notes`, `completed`, `deadline`, `creatAt`, `updateAt`) VALUES
(3, 4, 'Tarefa TodoApp', 'Rodas tela task e salvar no banco de dados ', 'Passar para gestor para o mesmo fazer a validacao.', 1, '2023-09-10', '2023-08-09 00:00:00', '2023-08-09 00:00:00'),
(4, 4, 'tarefa atualizar lista', 'descri??o	', 'notas', 0, '2020-10-10', '2023-08-10 00:00:00', '2023-08-10 00:00:00');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_projects` (`idProject`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `projects`
--
ALTER TABLE `projects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `fk_projects` FOREIGN KEY (`idProject`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
