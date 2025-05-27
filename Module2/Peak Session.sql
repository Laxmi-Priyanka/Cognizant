SELECT 
  event_id, 
  COUNT(*) AS peak_sessions_count
FROM 
  Sessions
WHERE 
  TIME(start_time) >= '10:00:00' 
  AND TIME(end_time) <= '12:00:00'
GROUP BY 
  event_id;
