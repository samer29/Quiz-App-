-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 07 déc. 2018 à 19:17
-- Version du serveur :  10.1.36-MariaDB
-- Version de PHP :  5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `quizapp`
--

-- --------------------------------------------------------

--
-- Structure de la table `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `question` text NOT NULL,
  `a` text NOT NULL,
  `b` text NOT NULL,
  `c` text NOT NULL,
  `d` text NOT NULL,
  `rightanswer` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `questions`
--

INSERT INTO `questions` (`id`, `question`, `a`, `b`, `c`, `d`, `rightanswer`) VALUES
(0, 'What animal infected with measles like a human being ?', 'Lion', 'Monkey', 'cat', 'dog', 'b'),
(1, 'What is the default value of the local variables?', 'Null', '0', 'Depends on the data type', 'No default value for local variables', 'd'),
(2, 'What displays from the following statements? String word = abcde; \\n for(int i=0; i<4; i+=2) System.out.print(word[i]);\\n', 'ab', 'ac', 'ace', 'bd', 'b'),
(3, 'What is a loop?', 'A new type of Applet', 'A segment of code to be run a specified amount of times', 'A segment of code to be run infinite times', 'A segment of code to be run once', 'b'),
(4, 'Following code will result in: int a1 = 5; double a2 = (float)a1;', 'Compilation error', 'Runtime error', 'No errors', 'None of above', 'c'),
(5, 'What is the highest index value associated with the array the follows? Byte[] values = new bytes[x];', '0', 'x', 'x-1', 'x+1', 'c'),
(6, 'What is the only type of exception that is NOT checked?', 'Class Exception', 'Class RunTimeException and its subclasses', 'Class IOException and its subclasses', 'Class ArithmeticException only', 'b'),
(7, 'What method of an Exception object returns a message string?', 'getError()', 'getMessage()', 'printMessage()', 'traceMessage()', 'b'),
(8, 'What type of exception is thrown by parseInt() if it gets illegal data?', 'ArithmeticException', 'RunTimeException', 'NumberFormatException', 'NumberError', 'c'),
(9, 'When is a finally{} block executed?', 'Only when an unhandled exception is thrown in a try{} block\";', 'Only when any exception is thrown in a try{} block', 'Always after execution has left a try{} block, no matter for what reason', 'Always just as a method is about to finish', 'c'),
(10, 'Which of the following will not directly cause a thread to stop?', 'notify()', 'wait()', 'InputStream access', 'sleep()', 'a'),
(11, 'wish is the biggest city in the World', 'Paris', 'New York', 'London', 'Madrid', 'c'),
(12, 'What animal infected with measles like a human being ?', 'Lion', 'Monkey', 'cat', 'dog', 'b'),
(13, 'Who is the strongest memory animal?', 'Elephant', 'Dog', 'Camel', 'Monkey', 'c'),
(14, 'What is the first university founded in the world?', 'Havard', 'MIT', 'The villagers in the Maghreb.', 'Zaytoun', 'c');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
