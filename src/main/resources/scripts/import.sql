## system attributes insertion
# created_at - current time
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);
INSERT INTO sys_attributes (created_at, modified_at) VALUES (CURRENT_TIME(), null);

## artists insertion
INSERT INTO artists (sys_attributes_id, first_name, surname) VALUES ('1', 'Leonardo', 'da Vinci');
INSERT INTO artists (sys_attributes_id, first_name, surname) VALUES ('2', 'Francisco', 'Goya');
INSERT INTO artists (sys_attributes_id, first_name, surname) VALUES ('3', 'Vincent', 'van Gogh');
INSERT INTO artists (sys_attributes_id, first_name, surname) VALUES ('4', 'Johannes', 'Vermeer');
INSERT INTO artists (sys_attributes_id, first_name, surname) VALUES ('5', 'Rembrandt', 'van Rijn');
INSERT INTO artists (sys_attributes_id, first_name, surname) VALUES ('6', 'Salvador', 'Dalí');
INSERT INTO artists (sys_attributes_id, first_name, surname) VALUES ('7', 'René', 'Magritte');

## arts insertion
INSERT INTO arts (artist_id, sys_attributes_id, title, year) VALUES ('1', '8', 'Mona Lisa', '1503');
insert into arts (artist_id, sys_attributes_id, title, year) values ('2', '9', 'Saturn devouring his son', '1819');
insert into arts (artist_id, sys_attributes_id, title, year) values ('3', '10', 'The starry night', '1889');
insert into arts (artist_id, sys_attributes_id, title, year) values ('4', '11', 'Girl with a pearl earring', '1665');
insert into arts (artist_id, sys_attributes_id, title, year) values ('5', '12', 'The night watch', '1642');
insert into arts (artist_id, sys_attributes_id, title, year) values ('6', '13', 'The persistence of memory', '1931');
insert into arts (artist_id, sys_attributes_id, title, year) values ('7', '14', 'The son of man', '1964');
