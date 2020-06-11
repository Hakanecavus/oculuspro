CREATE TRIGGER after_contact_insert AFTER INSERT on contact_lenses FOR EACH ROW
BEGIN
UPDATE  contact_lenses SET tarih = datetime(current_timestamp, 'localtime') WHERE id_contact=new.id_contact; 
END;

CREATE TRIGGER after_customer_insert AFTER INSERT on customer FOR EACH ROW
BEGIN
UPDATE  customer SET tarih = datetime(current_timestamp, 'localtime') WHERE id_customer=new.id_customer; 
END;

CREATE TRIGGER after_extras_insert AFTER INSERT on extras FOR EACH ROW
BEGIN
UPDATE  extras SET ekleme_tarihi = datetime(current_timestamp, 'localtime') WHERE id_extras=new.id_extras; 
END;

CREATE TRIGGER after_frames_insert AFTER INSERT on frames FOR EACH ROW
BEGIN
UPDATE  frames SET ekleme_tarihi = datetime(current_timestamp, 'localtime') WHERE id_frame=new.id_frame; 
END;

CREATE TRIGGER after_glass_insert AFTER INSERT on glass FOR EACH ROW
BEGIN
UPDATE  glass SET tarih = datetime(current_timestamp, 'localtime') WHERE id_glass=new.id_glass; 
END;

CREATE TRIGGER after_prescription_lens_insert AFTER INSERT on prescription_lens FOR EACH ROW
BEGIN
UPDATE  prescription_lens SET tarih = datetime(current_timestamp, 'localtime') WHERE id_presc_lens=new.id_presc_lens;
END;

CREATE TRIGGER after_prescription_cam_insert AFTER INSERT on prescription_cam FOR EACH ROW
BEGIN
UPDATE  prescription_cam SET tarih = datetime(current_timestamp, 'localtime') WHERE id_prescription=new.id_prescription;
END;

CREATE TRIGGER after_sale_insert AFTER INSERT on sale FOR EACH ROW
BEGIN
UPDATE  sale SET tarih = datetime(current_timestamp, 'localtime') WHERE id_sale=new.id_sale; 
END;

CREATE TRIGGER after_special_insert AFTER INSERT on special FOR EACH ROW
BEGIN
UPDATE  special SET ekleme_tarihi = datetime(current_timestamp, 'localtime') WHERE id_special=new.id_special; 
END


