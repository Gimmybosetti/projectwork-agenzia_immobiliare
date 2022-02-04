INSERT INTO slot_orari (descrizione) VALUES ('9:30 - 10:00');
INSERT INTO slot_orari (descrizione) VALUES ('10:00 - 10:30');
INSERT INTO slot_orari (descrizione) VALUES ('10:30 - 11:00');
INSERT INTO slot_orari (descrizione) VALUES ('11:00 - 11:30');
INSERT INTO slot_orari (descrizione) VALUES ('11:30 - 12:00');
INSERT INTO slot_orari (descrizione) VALUES ('12:00 - 12:30');
INSERT INTO slot_orari (descrizione) VALUES ('12:30 - 13:00');
INSERT INTO slot_orari (descrizione) VALUES ('13:00 - 13:30');
INSERT INTO slot_orari (descrizione) VALUES ('13:30 - 14:00');
INSERT INTO slot_orari (descrizione) VALUES ('14:00 - 14:30');
INSERT INTO slot_orari (descrizione) VALUES ('14:30 - 15:00');
INSERT INTO slot_orari (descrizione) VALUES ('15:00 - 15:30');
INSERT INTO slot_orari (descrizione) VALUES ('15:30 - 16:00');
INSERT INTO slot_orari (descrizione) VALUES ('16:00 - 16:30');
INSERT INTO slot_orari (descrizione) VALUES ('16:30 - 17:00');
INSERT INTO slot_orari (descrizione) VALUES ('17:00 - 17:30');
INSERT INTO slot_orari (descrizione) VALUES ('17:30 - 18:00');
INSERT INTO slot_orari (descrizione) VALUES ('18:00 - 18:30');

INSERT INTO tipologia (descrizione) VALUES ('Appartamento');
INSERT INTO tipologia (descrizione) VALUES ('Villa');
INSERT INTO tipologia (descrizione) VALUES ('Stanza singola');

INSERT INTO classe_energetica (descrizione) VALUES ('A4');
INSERT INTO classe_energetica (descrizione) VALUES ('A3');
INSERT INTO classe_energetica (descrizione) VALUES ('A2');
INSERT INTO classe_energetica (descrizione) VALUES ('A1');
INSERT INTO classe_energetica (descrizione) VALUES ('B');
INSERT INTO classe_energetica (descrizione) VALUES ('C');
INSERT INTO classe_energetica (descrizione) VALUES ('D');
INSERT INTO classe_energetica (descrizione) VALUES ('E');
INSERT INTO classe_energetica (descrizione) VALUES ('F');
INSERT INTO classe_energetica (descrizione) VALUES ('G');

INSERT INTO db_agenzia.agente
(cognome, nome)
VALUES('Rossi', 'Mario');
INSERT INTO db_agenzia.agente
(cognome, nome)
VALUES('Verdi', 'Luisa');
INSERT INTO db_agenzia.agente
(cognome, nome)
VALUES('Neri', 'Davide');
INSERT INTO db_agenzia.agente
(cognome, nome)
VALUES('Blu', 'Cassandra');
INSERT INTO db_agenzia.agente
(cognome, nome)
VALUES('Bianchi', 'Samuele');


INSERT INTO db_agenzia.cliente
(cognome, email, nome, phone)
VALUES('Zucca', 'zuccaemail1@gmail.com', 'Alfonso', '333211654');
INSERT INTO db_agenzia.cliente
(cognome, email, nome, phone)
VALUES('Pepe', 'pepemail1@gmail.com', 'Augusto', '321654987');
INSERT INTO db_agenzia.cliente
(cognome, email, nome, phone)
VALUES('Manzo', 'manzoemail1@gmail.com', 'Renata', '354987321');
INSERT INTO db_agenzia.cliente
(cognome, email, nome, phone)
VALUES('Fiordi', 'fiordiemail1@gmail.com', 'Erasmo', '315321123');
INSERT INTO db_agenzia.cliente
(cognome, email, nome, phone)
VALUES('Zarillo', 'zarilloemail1@gmail.com', 'Giulia', '397654123');
INSERT INTO db_agenzia.cliente
(cognome, email, nome, phone)
VALUES('Conte', 'contemail1@gmail.com', 'Patrick', '374369258');

INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 1200, '2022-12-23', 0, 'Via Contrada Caruso 4', 1, 80, 1, 1, 1, 0, 'Appartamento del sole', 1, 1, 1);
INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 15000, '2022-01-23', 1, 'Via Caputo 02', 0, 120, 2, 2, 1, 0, 'Appartamento di nuova costruzione', 1, 2, 1);
INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 2000, '2022-02-24', 0, 'Via Contrada Giacinta 42', 1, 90, 1, 1, 2, 0, 'Monolocale in centro', 2, 3, 1);
INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 800000, '2022-03-25', 1, 'Via Contrada Carbone 9', 0, 250, 3, 2, 6, 0, 'Quadrilocale interamente ristrutturato', 2, 4, 2);
INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 250, '2022-04-26', 0, 'Strada Joannes 32', 1, 40, 1, 0, 1, 0, 'Camera singola con vista', 3, 5, 3);
INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 1400, '2022-02-14', 0, 'Piazza Vitali 90', 0, 60, 1, 1, 1, 0, 'Stanza singola in attico', 4, 6, 3);
INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 650, '2022-02-13', 0, 'Via Rotonda Mietta 76', 1, 100, 2, 2, 2, 0, '', 5, 7, 1);
INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 410000, '2022-02-12', 1, 'Piazza Giovanna 880', 1, 200, 4, 5, 4, 0, 'Villetta dei conti', 5, 8, 2);
INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 2300000, '2022-02-11', 1, 'Piazza Pellegrino 4', 0, 320, 4, 4, 8, 0, 'Villa fiorita unifamiliare', 4, 9, 2);
INSERT INTO db_agenzia.immobile
(cancellato, canone, data_ins, in_vendita, indirizzo, libero, metri, n_bagni, n_balconi, n_stanze, num_visual, titolo, agente_id, classe_energetica_id, tipologia_id)
VALUES(0, 3000, '2022-02-10', 0, 'Strada Mazza 66', 0, 140, 3, 3, 2, 0, 'Appartamento per famiglia', 3, 10, 1);



INSERT INTO db_agenzia.appuntamento
(`data`, agente_id, cliente_id, immobile_id, slot_orari_id)
VALUES('2022-09-08', 1, 1, 1, 1);
INSERT INTO db_agenzia.appuntamento
(`data`, agente_id, cliente_id, immobile_id, slot_orari_id)
VALUES('2022-08-18', 2, 2, 2, 2);
INSERT INTO db_agenzia.appuntamento
(`data`, agente_id, cliente_id, immobile_id, slot_orari_id)
VALUES('2022-02-02', 3, 3, 3, 3);
INSERT INTO db_agenzia.appuntamento
(`data`, agente_id, cliente_id, immobile_id, slot_orari_id)
VALUES('2022-01-03', 4, 4, 4, 4);
INSERT INTO db_agenzia.appuntamento
(`data`, agente_id, cliente_id, immobile_id, slot_orari_id)
VALUES('2022-05-16', 5, 5, 5, 5);


