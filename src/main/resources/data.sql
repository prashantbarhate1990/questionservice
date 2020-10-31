DROP TABLE IF EXISTS questions;
 
CREATE TABLE questions (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  question VARCHAR(250) NOT NULL,
  description VARCHAR(250)
);
 
INSERT INTO questions (id, question, description) VALUES
  (1, 'what is a Rest API?', 'What is Rest API, why is it used, and how can I go about creating one and learning more about it?');
  
INSERT INTO questions (id, question, description) VALUES
  (2, 'How to configure port for a Spring Boot application?', 'How do I configure the TCP/IP port listened on by a Spring Boot application, so it does not use the default port of 8080.'),
  (3, '@RequestParam vs @PathVariable', 'What is the difference between @RequestParam and @PathVariable?');