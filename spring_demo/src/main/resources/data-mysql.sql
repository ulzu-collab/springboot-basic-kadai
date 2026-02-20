INSERT INTO users (email, password, role, created_at)
SELECT 'admin@example.com', '{bcrypt}...', 'ADMIN', NOW()
WHERE NOT EXISTS (
	SELECT 1 FROM users WHERE email = 'admin@example.com'
);