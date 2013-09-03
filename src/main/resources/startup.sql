CREATE TABLE page_view 
  ( 
     id             INT NOT NULL auto_increment, 
     traffic_source VARCHAR(100), 
     social_source  VARCHAR(100), 
     url            VARCHAR(100), 
     domain         VARCHAR(100), 
     logged_at      TIMESTAMP, 
     PRIMARY KEY(id) 
  ) 