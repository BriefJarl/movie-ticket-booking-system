-- Phase A: Expand schema with new columns matching Review domain entity
ALTER TABLE reviews
ADD COLUMN movie_review TEXT DEFAULT NULL,
ADD COLUMN user_id BIGINT DEFAULT NULL,
ADD COLUMN created_date DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6),
ADD COLUMN updated_date DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6);

-- Phase B: Backfill movie_review from legacy comment for existing rows (preserving comment column)
UPDATE reviews
SET movie_review = comment
WHERE movie_review IS NULL
  AND comment IS NOT NULL;

-- Phase C: Type alignment - widen rating from INT to DOUBLE
ALTER TABLE reviews
MODIFY COLUMN rating DOUBLE DEFAULT NULL;

-- Phase D: User foreign key constraint targeting authoritative users table
ALTER TABLE reviews
ADD CONSTRAINT fk_reviews_user_id
FOREIGN KEY (user_id) REFERENCES users(id);
