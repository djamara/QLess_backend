SELECT *,TIME_FORMAT(AVG(cast(traitement.ticket_heure_update AS TIME)),"%T") AS 'duree_traitement' FROM traitement WHERE (traitement.`status` ='termine' OR traitement.`status`='en_traitement') GROUP BY traitement.reception_id;

SELECT * FROM traitement WHERE (traitement.`status`="termine" OR traitement.`status`="transferer") AND traitement.agent_id = -42 AND company_id=1;

SELECT COUNT(traitement.id) AS totalTermine FROM traitement WHERE traitement.`status`="termine" AND traitement.agent_id = -46 AND company_id=1;

SELECT COUNT(traitement.id) AS totaltransferer FROM traitement WHERE traitement.`status`="transferer" AND traitement.agent_id = -46 AND company_id=1;

SELECT COUNT(traitement.id) AS totalTraitement FROM traitement WHERE traitement.`status`="en_traitement" AND traitement.agent_id = -46 AND company_id=1;