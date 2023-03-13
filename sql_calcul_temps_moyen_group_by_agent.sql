SELECT * FROM traitement WHERE traitement.reception_id = 64;
SELECT * FROM traitement WHERE (traitement.`status` ="termine" OR traitement.`status`="en_traitement") AND traitement.agent_id=-45 AND traitement.reception_id=64;
SELECT TIME_FORMAT(AVG(cast(traitement.ticket_heure_update AS TIME)),"%T") AS "temps moyen de traitement", traitement.agent_id, traitement.reception_id FROM traitement WHERE (traitement.`status` ="termine" OR traitement.`status`="en_traitement") GROUP BY traitement.reception_id;
