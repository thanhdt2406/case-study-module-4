use case4;
insert into app_role(name)
values ('ROLE_ADMIN'),
       ('ROLE_SHOP'),
       ('ROLE_USER');

insert into app_user(username, password, address, email, name, phone_number, role_id)
values ('admin123', '123456', 'HaNoi', 'abc@example.com', 'Admin', '012456789', 1),
       ('thanhdt', '123456', 'HaNoi', 'abc@example.com', 'ThanhDT', '012456789', 2),
       ('vietdq', '123456', 'HaNoi', 'abc@example.com', 'VietDQ', '012456789', 2),
       ('dungvt', '123456', 'HaNoi', 'abc@example.com', 'DungVT', '012456789', 2),
       ('thanhdo', '123456', 'HaNoi', 'abc@example.com', 'Thanh User', '012456789', 3),
       ('vietdo', '123456', 'HaNoi', 'abc@example.com', 'Viet User', '012456789', 3),
       ('dungvo', '123456', 'HaNoi', 'abc@example.com', 'Dung User', '012456789', 3),
       ('user123', '123456', 'HaNoi', 'abc@example.com', 'User user', '012456789', 3);

insert into cart(cart_id,app_user_id)
values (1,1),
       (2,2),
       (3,3),
       (4,4),
       (5,5),
       (6,6),
       (7,7),
       (8,8);


insert into category(name)
values ('bags'),
       ('balls'),
       ('caps'),
       ('clothes'),
       ('laptop'),
       ('shoes'),
       ('socks'),
       ('television');

insert into shop(address, description, name, app_user_id) values
('Viet Nam','Day la shop cua Thanh','Thanh-Shop',2),
('Viet Nam','Day la shop cua Viet','Viet-Shop',3),
('Viet Nam','Day la shop cua Dung','Dung-Shop',4);

alter table product modify column create_date datetime default now();

insert into product(name,image,quantity,price,description,category_id,shop_id) values

('Ba_lo_DJen_GE1233_standard','3S_RSPNS_BP_DJen_GE1233_01_standard.jpg',20,1500000,'New',1,2),
('Ba_lo_Classic_Adicolor_DJen_GD4575','Ba_lo_Classic_Adicolor_co_nho_DJen_GD4575_01_standard.jpg',10,1700000,'New',1,3),
('Ba_lo_Classic_Adicolor_DJen_GD4545','Ba_lo_Classic_Adicolor_DJen_GD4545_01_standard.jpg',31,1650000,'New',1,1),
('Ba_lo_Classic_Adicolor_DJen_GD4556','Ba_lo_Classic_Adicolor_DJen_GD4556_01_standard.jpg',55,1300000,'New',1,2),
('Ba_lo_Classic_DJen_GL7782','Ba_lo_Classic_DJen_GL7782_01_standard.jpg',10,1200000,'New',1,2),
('Ba_lo_Classic_Tricolor_Adicolor_DJen_GN4957','Ba_lo_Classic_Tricolor_Adicolor_DJen_GN4957_01_standard.jpg',10,1100000,'New',1,1),
('Ba_lo_Daily_Linear_Classic_DJen_GE5566','Ba_lo_Daily_Linear_Classic_DJen_GE5566_01_standard.jpg',20,1540000,'New',1,1),
('Ba_lo_Daily_Linear_Classic_GN2077','Ba_lo_Daily_Linear_Classic_Mau_xanh_da_troi_GN2077_01_standard.jpg',10,1543000,'New',1,2),
('Ba_lo_Endurance_Packing_System_30_DJen_GL8573','Ba_lo_Endurance_Packing_System_30_DJen_GL8573_01_standard.jpg',30,1500000,'New',1,1),
('Ba_lo_HER_Studio_London_GN2131','Ba_lo_HER_Studio_London_Nhieu_mau_GN2131_01_standard.jpg',20,1500000,'New',1,2),
('Ba_lo_Logo_Essentials_DJen_GN2014','Ba_lo_Logo_Essentials_DJen_GN2014_01_standard.jpg',20,1000000,'New',1,1),
('Ba_lo_Logo_Essentials_GN2015','Ba_lo_Logo_Essentials_Mau_xanh_da_troi_GN2015_01_standard.jpg',10,1760000,'New',1,3),
('Ba_lo_Manchester_United_FS0155','Ba_lo_Manchester_United_mau_xanh_la_FS0155_01_standard.jpg',30,2000000,'New',1,1),
('Ba_lo_mini_Tricolor_Adicolor_DJen_GN5097','Ba_lo_mini_Tricolor_Adicolor_DJen_GN5097_01_standard.jpg',31,900000,'New',1,3),
('Ba_lo_mini_Xam_GN3038','Ba_lo_mini_Xam_GN3038_01_standard.jpg',55,1230000,'New',1,1),
('Ba_lo_nap_cuon_Premium_Essentials_FN1477','Ba_lo_nap_cuon_Premium_Essentials_Mau_xanh_da_troi_FN1477_01_standard.jpg',10,1599000,'New',1,2),
('Ba_lo_nap_tren_Street_DJen_FM1282','Ba_lo_nap_tren_Street_DJen_FM1282_01_standard.jpg',10,1999000,'New',1,1),
('Ba_lo_Parkhood_DJen_DZ9020','Ba_lo_Parkhood_DJen_DZ9020_01_standard.jpg',60,1634000,'New',1,2),
('Ba_lo_Power_5_DJen_FI7968','Ba_lo_Power_5_DJen_FI7968_01_standard.jpg',10,1511000,'New',1,3),
('Ba_lo_Power_5_GL0952','Ba_lo_Power_5_Mau_xanh_da_troi_GL0952_01_standard.jpg',60,1123000,'New',1,2),
('Ba_lo_twill_Classic_DJen_GD2610','Ba_lo_vai_twill_Classic_DJen_GD2610_01_standard.jpg',10,1258000,'New',1,1),
('Ba_lo_CLASSIC_BP_FAST_3S_DJen_FS8334','CLAS_BP_FAST_3S_DJen_FS8334_01_standard.jpg',47,1363000,'New',1,1),
('Ba_lo_CLASSIC_BP_BOS_FT8762','CLASSIC_BP_BOS_Mau_xanh_da_troi_FT8762_01_standard.jpg',10,1112000,'New',1,3),

('Bong_Starlancer_Club_GK3499','Bong_Starlancer_Club_trang_GK3499_01_standard.jpg',47,800000,'New',2,2),
('Bong_Starlancer_Club_GK3500','Bong_Starlancer_Club_trang_GK3500_01_standard.jpg',10,750000,'New',2,1),

('Mu_aerobill-featherlight-running-MvT1cM','aerobill-featherlight-running-cap-MvT1cM.jpg',60,300000,'New',3,2),
('Mu_aerobill-legacy91-training-1TrTBz','aerobill-legacy91-training-hat-1TrTBz.jpg',55,199000,'New',3,1),
('Mu_aerobill-tailwind-air-chaz-bear-running-csq5jN','aerobill-tailwind-air-chaz-bear-running-cap-csq5jN.jpg',31,260000,'New',3,2),
('Mu_dri-fit-aerobill-featherlight-knit-running-BLH1TF','dri-fit-aerobill-featherlight-knit-running-cap-BLH1TF.jpg',10,182000,'New',3,2),
('Mu_dri-fit-aerobill-tailwind-running-XxWSFH','dri-fit-aerobill-tailwind-running-cap-XxWSFH.jpg',47,189000,'New',3,1),
('Mu_heritage86-giannis-freak-basketball-FF5ttn','heritage86-giannis-freak-basketball-cap-FF5ttn.jpg',20,157000,'New',3,2),
('Mu_jordan-23-engineered-aw84-7PHvZ0','jordan-23-engineered-aw84-cap-7PHvZ0.jpg',31,452000,'New',3,1),
('Mu_jordan-dri-fit-jumpman-headband-9V70qg','jordan-dri-fit-jumpman-headband-9V70qg.jpg',60,510000,'New',3,2),
('Mu_jordan-heritage86-aj6-vault-X0kW8M','jordan-heritage86-aj6-vault-cap-X0kW8M.jpg',10,500000,'New',3,2),
('Mu_jordan-jumpman-classics-pro-Lnm3zF','jordan-jumpman-classics-pro-cap-Lnm3zF.jpg',60,499000,'New',3,1),
('Mu_jordan-jumpman-heritage86-hVDclC','jordan-jumpman-heritage86-hat-hVDclC.jpg',10,430000,'New',3,3),
('Mu_jordan-legacy-91-0fxfW7','jordan-legacy-91-cap-0fxfW7.jpg',10,400000,'New',3,1),
('Mu_jordan-pro-jumpman-snapback-KbPBND','jordan-pro-jumpman-snapback-hat-KbPBND.jpg',10,560000,'New',3,2),
('Mu_jordan-pro-sport-dna-chenille-c7p7hv','jordan-pro-sport-dna-chenille-cap-c7p7hv.jpg',31,536000,'New',3,1),
('Mu_legacy91-golf-KN3jRL','legacy91-golf-hat-KN3jRL.jpg',10,580000,'New',3,1),
('Mu_liverpool-fc-heritage86-adjustable-DmV11X','liverpool-fc-heritage86-adjustable-hat-DmV11X.jpg',60,500000,'New',3,1),
('Mu_liverpool-fc-pom-beanie-c6WlZq','liverpool-fc-pom-beanie-c6WlZq.jpg',55,500000,'New',3,1),
('Mu_paris-saint-germain-cuffed-beanie-Lv0F20','paris-saint-germain-cuffed-beanie-Lv0F20.jpg',10,499000,'New',3,1),
('Mu_paris-saint-germain-pom-beanie-RppJqt','paris-saint-germain-pom-beanie-RppJqt.jpg',47,530000,'New',3,2),
('Mu_paris-saint-germain-pro-41p9NX','paris-saint-germain-pro-cap-41p9NX.jpg',27,480000,'New',3,2),
('Mu_sportswear-aerobill-featherlight-adjustable-Z4bzwl','sportswear-aerobill-featherlight-adjustable-cap-Z4bzwl.jpg',10,513000,'New',3,3),
('Mu_sportswear-classic-99-trucker-6fLZlP','sportswear-classic-99-trucker-hat-6fLZlP.jpg',55,399000,'New',3,1),
('Mu_sportswear-dri-fit-pro-futura-adjustable-wDx9WF','sportswear-dri-fit-pro-futura-adjustable-cap-wDx9WF.jpg',10,250000,'New',3,3),
('Mu_sportswear-heritage-86-cc54mX','sportswear-heritage-86-cap-cc54mX.jpg',60,210000,'New',3,1),
('Mu_sportswear-worldwide-adjustable-ctzKTf','sportswear-worldwide-adjustable-cap-ctzKTf.jpg',20,263000,'New',3,2),
('Mu_swoosh-headband-fHBQ1J','swoosh-headband-fHBQ1J.jpg',10,130000,'New',3,1),

('acg-fleece-crew-sweatshirt-5thnbV','acg-fleece-crew-sweatshirt-5thnbV.jpg',19,500000,'New',4,1),
('acg-long-sleeve-t-shirt-ZDbnFD','acg-long-sleeve-t-shirt-ZDbnFD.jpg',30,590000,'New',4,3),
('acg-long-sleeve-top-mlvZVc','acg-long-sleeve-top-mlvZVc.jpg',30,560000,'New',4,2),
('acg-polartec-wolf-tree-fleece-top-2ZdSRm','acg-polartec-wolf-tree-fleece-top-2ZdSRm.jpg',55,550000,'New',4,1),
('acg-polartec-wolf-tree-pullover-hoodie-BjNLhx','acg-polartec-wolf-tree-pullover-hoodie-BjNLhx.jpg',10,350000,'New',4,2),
('acg-polartec-wolf-tree-trousers-zVgVB1','acg-polartec-wolf-tree-trousers-zVgVB1.jpg',19,850000,'New',4,3),
('acg-rope-de-dope-ultra-rock-packable-insulated-jacket-6X9JW6','acg-rope-de-dope-ultra-rock-packable-insulated-jacket-6X9JW6.jpg',10,350000,'New',4,1),
('acg-short-sleeve-t-shirt-stb0Pw','acg-short-sleeve-t-shirt-stb0Pw.jpg',27,150000,'New',4,2),
('acg-stargaze-short-sleeve-t-shirt-0vC7Fb','acg-stargaze-short-sleeve-t-shirt-0vC7Fb.jpg',10,159000,'New',4,1),
('acg-trail-trousers-kZzlwc','acg-trail-trousers-kZzlwc.jpg',13,452000,'New',4,1),
('Ao_jersey_21_ke_soc_DJo_GN7624_21_model','Ao_jersey_21_ke_soc_DJo_GN7624_21_model.jpg',20,250000,'New',4,2),
('Ao_jersey_21_ke_soc_Mau_xanh_da_troi_GH7321_21_model','Ao_jersey_21_ke_soc_Mau_xanh_da_troi_GH7321_21_model.jpg',30,450000,'New',4,2),
('Ao_thun_3_Soc_adidas_Sportswear_DJen_GP9512_21_model','Ao_thun_3_Soc_adidas_Sportswear_DJen_GP9512_21_model.jpg',10,580000,'New',4,1),
('Ao_thun_3_Soc_Classics_Adicolor_DJen_GN3495_21_model','Ao_thun_3_Soc_Classics_Adicolor_DJen_GN3495_21_model.jpg',30,590000,'New',4,2),
('Ao_thun_3_Soc_Classics_Adicolor_trang_GN3494_21_model','Ao_thun_3_Soc_Classics_Adicolor_trang_GN3494_21_model.jpg',10,560000,'New',4,3),
('Ao_thun_3_Soc_Essentials_DJen_GL3732_21_model','Ao_thun_3_Soc_Essentials_DJen_GL3732_21_model.jpg',19,500000,'New',4,1),
('Ao_thun_3_Soc_Essentials_Mau_xanh_da_troi_GL3734_21_model','Ao_thun_3_Soc_Essentials_Mau_xanh_da_troi_GL3734_21_model.jpg',10,350000,'New',4,3),
('Ao_thun_3_Soc_Essentials_Xam_GL3735_21_model','Ao_thun_3_Soc_Essentials_Xam_GL3735_21_model.jpg',55,610000,'New',4,2),
('Ao_thun_3_Soc_the_thao_Primeblue_Designed_To_Move_trang_GM2135_21_model','Ao_thun_3_Soc_the_thao_Primeblue_Designed_To_Move_trang_GM2135_21_model.jpg',30,340000,'New',4,1),
('Ao_thun_Ba_La_Classics_Adicolor_DJen_GN3462_21_model','Ao_thun_Ba_La_Classics_Adicolor_DJen_GN3462_21_model.jpg',13,270000,'New',4,1),
('Ao_thun_Ba_La_Classics_Adicolor_trang_GN3463_21_model','Ao_thun_Ba_La_Classics_Adicolor_trang_GN3463_21_model.jpg',31,390000,'New',4,2),
('Ao_thun_dang_hop_Ba_La_Back_and_Front_Classics_Adicolor_trang_GN3453_21_model','Ao_thun_dang_hop_Ba_La_Back_and_Front_Classics_Adicolor_trang_GN3453_21_model.jpg',10,340000,'New',4,1),
('Ao_thun_logo_adidas_Sportswear_DJen_GP9503_21_model','Ao_thun_logo_adidas_Sportswear_DJen_GP9503_21_model.jpg',20,520000,'New',4,1),
('Ao_thun_the_thao_3_Soc_AEROREADY_Designed_To_Move_DJen_GM2105_21_model','Ao_thun_the_thao_3_Soc_AEROREADY_Designed_To_Move_DJen_GM2105_21_model.jpg',30,530000,'New',4,1),
('Ao_thun_the_thao_3_Soc_AEROREADY_Designed_To_Move_trang_GM2156_21_model','Ao_thun_the_thao_3_Soc_AEROREADY_Designed_To_Move_trang_GM2156_21_model.jpg',31,510000,'New',4,1),
('Ao_thun_the_thao_AEROREADY_Designed_To_Move_DJen_GM2090_21_model','Ao_thun_the_thao_AEROREADY_Designed_To_Move_DJen_GM2090_21_model.jpg',10,460000,'New',4,3),
('Ao_thun_the_thao_AEROREADY_Designed_To_Move_DJo_GM2108_21_model','Ao_thun_the_thao_AEROREADY_Designed_To_Move_DJo_GM2108_21_model.jpg',60,430000,'New',4,2),
('CAMPEON_21_JSY_DJen_FT6760_21_model','CAMPEON_21_JSY_DJen_FT6760_21_model.jpg',31,400000,'New',4,3),
('CAMPEON_21_JSY_trang_GN5719_21_model','CAMPEON_21_JSY_trang_GN5719_21_model.jpg',10,490000,'New',4,2),
('CLUB_3STR_POLO_DJen_GL5421_21_model','CLUB_3STR_POLO_DJen_GL5421_21_model.jpg',27,470000,'New',4,1),
('CLUB_3STR_POLO_trang_GL5416_21_model','CLUB_3STR_POLO_trang_GL5416_21_model.jpg',19,350000,'New',4,2),
('dri-fit-eliud-running-t-shirt-nzmPwB','dri-fit-eliud-running-t-shirt-nzmPwB.jpg',10,310000,'New',4,3),
('flex-stride-air-chaz-bear-running-shorts-mkcgWV','flex-stride-air-chaz-bear-running-shorts-mkcgWV.jpg',10,300000,'New',4,1),
('jordan-air-basketball-shorts-ktR2qQ','jordan-air-basketball-shorts-ktR2qQ.jpg',13,300000,'New',4,2),
('jordan-aj1-shoe-crew-0C8D3F','jordan-aj1-shoe-crew-0C8D3F.jpg',10,380000,'New',4,1),
('jordan-aj4-graphic-fleece-pullover-hoodie-9JhxcD','jordan-aj4-graphic-fleece-pullover-hoodie-9JhxcD.jpg',10,290000,'New',4,3),
('jordan-aj4-graphic-fleece-shorts-vNGTGQ','jordan-aj4-graphic-fleece-shorts-vNGTGQ.jpg',27,390000,'New',4,3),
('jordan-aj4-graphic-fleece-trousers-MLq3Fb','jordan-aj4-graphic-fleece-trousers-MLq3Fb.jpg',55,240000,'New',4,2),
('jordan-aj4-lightweight-jacket-dvd0Z4','jordan-aj4-lightweight-jacket-dvd0Z4.jpg',10,220000,'New',4,1),
('jordan-aj4-long-sleeve-graphic-t-shirt-BNjM7z','jordan-aj4-long-sleeve-graphic-t-shirt-BNjM7z.jpg',20,240000,'New',4,2),
('jordan-aj11-graphic-fleece-pullover-hoodie-hGbBW0','jordan-aj11-graphic-fleece-pullover-hoodie-hGbBW0.jpg',13,310000,'New',4,1),
('jordan-aj11-graphic-fleece-trousers-KDv10d','jordan-aj11-graphic-fleece-trousers-KDv10d.jpg',10,450000,'New',4,2),
('jordan-aj11-graphic-t-shirt-BbWl3p','jordan-aj11-graphic-t-shirt-BbWl3p.jpg',10,1500000,'New',4,3),
('jordan-aj11-long-sleeve-graphic-t-shirt-p92ZTg','jordan-aj11-long-sleeve-graphic-t-shirt-p92ZTg.jpg',13,530000,'New',4,1),
('jordan-jumpman-chimney-long-sleeve-t-shirt-5XS0KM','jordan-jumpman-chimney-long-sleeve-t-shirt-5XS0KM.jpg',60,510000,'New',4,2),
('malaysia-2020-stadium-away-football-shirt-Jkf2cm','malaysia-2020-stadium-away-football-shirt-Jkf2cm.jpg',10,520000,'New',4,3),
('malaysia-2020-stadium-home-football-shirt-pZ6swZ','malaysia-2020-stadium-home-football-shirt-pZ6swZ.jpg',13,500000,'New',4,2),
('polo-naomi-osaka-slim-fit-polo-wBs8PT','polo-naomi-osaka-slim-fit-polo-wBs8PT.jpg',30,500000,'New',4,1),
('Quan_short_Chelsea_3_Soc_AEROREADY_Essentials_DJen_GL0022_21_model','Quan_short_Chelsea_3_Soc_AEROREADY_Essentials_DJen_GL0022_21_model.jpg',30,200000,'New',4,2),
('Quan_short_Chelsea_3_Soc_AEROREADY_Essentials_Mau_xanh_da_troi_GL0023_21_model','Quan_short_Chelsea_3_Soc_AEROREADY_Essentials_Mau_xanh_da_troi_GL0023_21_model.jpg',10,250000,'New',4,1),
('rise-365-air-chaz-bear-running-top-sG69sJ','rise-365-air-chaz-bear-running-top-sG69sJ.jpg',10,230000,'New',4,3),
('sportswear-t-shirt-Mw4s2J','sportswear-t-shirt-Mw4s2J.jpg',17,210000,'New',4,1),
('sportswear-tech-fleece-pullover-hoodie-64bvBq','sportswear-tech-fleece-pullover-hoodie-64bvBq.jpg',55,520000,'New',4,3),
('Track_jacket_Tricolor_Adicolor_DJen_GN3582_21_model','Track_jacket_Tricolor_Adicolor_DJen_GN3582_21_model.jpg',20,250000,'New',4,2),
('undercover-2-in-1-trousers-fFXfxm','undercover-2-in-1-trousers-fFXfxm.jpg',60,230000,'New',4,1),
('undercover-parka-06WMGq','undercover-parka-06WMGq.jpg',13,270000,'New',4,1),

('Laptop_microsoft_surface_pro_6_tablet','207_microsoft_surface_pro_6_tablet_anh4.jpg',30,29990000,'New',5,1),
('Laptop_surface','4979_surface_laptop_3__anh2.jpg',27,30000000,'New',5,1),
('Laptop_surface_pro','4989_surface_pro_7_anh4.jpg',19,39000000,'New',5,3),
('Laptop_asus_zenbook_ux481fl','5042_asus_zenbook_ux481fl_anh2.jpg',19,29000000,'New',5,2),
('Laptop_dell_xps_13_7390_silver','5205_dell_xps_13_7390_silver__1.jpg',31,28000000,'New',5,1),
('Laptop_dell_vosro_v3590a','5358_dell_vosro_v3590a__anh1.jpg',19,22000000,'New',5,3),
('Laptop_lg_gram_2020_14zd90n','5755_lg_gram_2020_14zd90n_1.jpg',10,29000000,'New',5,1),
('Laptop_lg_gram_2020_15z90n','5759_lg_gram_2020_15z90n_1.jpg',27,27000000,'New',5,2),
('Laptop_msi_gf63_thin_10scsr_077vn','5797_msi_gf63_thin_10scsr_077vn_1.jpg',10,15000000,'New',5,1),
('Laptop_asus_rog_zephyrus_g15_ga502iu','5840_asus_rog_zephyrus_g15_ga502iu_1.jpg',17,19630000,'New',5,2),
('Laptop_tuf_gaming_a15_fa506','5880_tuf_gaming_a15_fa506.jpg',10,35210000,'New',5,1),
('Laptop_surface_go_2','5947_surface_go_2_1.jpg',10,1500000,'New',5,1),
('Laptop_surface_book_3_13_5_g','5953_surface_book_3_13_5_g.jpg',17,18000000,'New',5,3),
('Laptop_asus_rog_zephyrus_g14_ga401ii_he019t','6223_asus_rog_zephyrus_g14_ga401ii_he019t__6.jpg',10,28500000,'New',5,2),
('Laptop_asus_rog_zephyrus_g14','6224_asus_rog_zephyrus_g14__3.jpg',19,36900000,'New',5,1),
('Laptop_gaming_rog_zephyrus_m15','6232_gaming_rog_zephyrus_m15.jpg',20,37500000,'New',5,2),
('Laptop_hp_pavilion_x360_14_dw0061tu','6256_hp_pavilion_x360_14_dw0061tu_5.jpg',10,32500000,'New',5,3),
('Laptop_asus_rog_strix_g17_g712l','6320_asus_rog_strix_g17_g712l_2.jpg',55,1500000,'New',5,3),
('Laptop_4784_dell_inspiron_15_g3_3590','6354_4784_dell_inspiron_15_g3_3590_anh3.jpg',17,21000000,'New',5,1),
('Laptop_4784_dell_inspiron_15_g3_3590','6354_4784_dell_inspiron_15_g3_3590_anh4.jpg',10,17800000,'New',5,2),
('Laptop_zephyrus_duo_15','6487_zephyrus_duo_15.jpg',10,35200000,'New',5,1),
('Laptop_rog_zephyrus_g15_ga502iv','6614_rog_zephyrus_g15_ga502iv_3.jpg',10,34300000,'New',5,1),
('Laptop_inspiron_5500','6623_inspiron_5500_5.jpg',31,36500000,'New',5,3),
('Laptop_surface_go_3','7135_surface_laptop_go_3.jpg',49,18600000,'New',5,2),

('Giay_air-force-1-07-craft-LLV6ng','air-force-1-07-craft-shoe-LLV6ng.jpg',49,2300000,'New',6,1),
('Giay_air-max-1-SS9rJG','air-max-1-SS9rJG.jpg',10,3100000,'New',6,1),
('Giay_air-zoom-tempo-next-running-chNfdw','air-zoom-tempo-next-running-shoe-chNfdw.jpg',10,3500000,'New',6,3),
('Giay_BRAVADA_MID_DJen_FX9064','BRAVADA_MID_DJen_FX9064_01_standard.jpg',14,3200000,'New',6,1),
('Giay_BRAVADA_MID_FX9063','BRAVADA_MID_trang_FX9063_01_standard.jpg',22,2600000,'New',6,2),
('Giay_custom-kyrie-7','custom-kyrie-7-by-you.jpg',49,2900000,'New',6,3),
('Giay_Courtrook_FY5933','Giay_Courtrook_trang_FY5933_01_standard.jpg',27,2700000,'New',6,1),
('Giay_Duramo_SL_DJo_FY6682','Giay_Duramo_SL_DJo_FY6682_01_standard.jpg',11,2300000,'New',6,1),
('Giay_Fluidflow_2.0_DJen_FZ1983','Giay_Fluidflow_2.0_DJen_FZ1983_01_standard.jpg',10,3200000,'New',6,3),
('Giay_NMD_R1_FY5730','Giay_NMD_R1_Bac_FY5730_01_standard.jpg',49,1600000,'New',6,2),
('Giay_NMD_R1_DJen_FY5727','Giay_NMD_R1_DJen_FY5727_01_standard.jpg',11,1900000,'New',6,2),
('Giay_Response_Run_DJen_FY9580','Giay_Response_Run_DJen_FY9580_01_standard.jpg',10,1800000,'New',6,1),
('Giay_Ultraboost_4.0_DNA_DJen_FY9318','Giay_Ultraboost_4.0_DNA_DJen_FY9318_01_standard.jpg',23,1700000,'New',6,3),
('Giay_Ultraboost_4.0_DNA_FY9120','Giay_Ultraboost_4.0_DNA_trang_FY9120_01_standard.jpg',22,1900000,'New',6,1),
('Giay_Ultraboost_4.0_DNA_FY9319','Giay_Ultraboost_4.0_DNA_Xam_FY9319_01_standard.jpg',49,2600000,'New',6,2),
('Giay_Ultraboost_5.0_DNA_DJen_FZ1855','Giay_Ultraboost_5.0_DNA_DJen_FZ1855_01_standard.jpg',60,3500000,'New',6,3),
('Giay_Ultraboost_5.0_DNA_FX7973','Giay_Ultraboost_5.0_DNA_Mau_xanh_da_troi_FX7973_01_standard.jpg',49,3600000,'New',6,2),
('Giay_UltraBoost_20_DJen_FX7979','Giay_UltraBoost_20_DJen_FX7979_01_standard.jpg',23,3700000,'New',6,1),
('Giay_Ultraboost_20_DNA_FX7957','Giay_Ultraboost_20_DNA_Xam_FX7957_01_standard.jpg',10,3500000,'New',6,1),
('Giay_X9000L4_FX8439','Giay_X9000L4_Xam_FX8439_01_standard.jpg',23,2300000,'New',6,3),
('Giay_kybrid-s2-ep-basketball-d6GWxh','kybrid-s2-ep-basketball-shoe-d6GWxh.jpg',14,2600000,'New',6,3),
('Giay_kyrie-6-ep-basketball-0tRPJ4','kyrie-6-ep-basketball-shoe-0tRPJ4.jpg',60,3800000,'New',6,2),
('Giay_kyrie-6-older-basketball-K9GW3v','kyrie-6-older-basketball-shoe-K9GW3v.jpg',10,3700000,'New',6,2),
('Giay_kyrie-7-ep-basketball-kMwm27','kyrie-7-ep-basketball-shoe-kMwm27.jpg',23,2600000,'New',6,1),
('Giay_kyrie-7-ep-sisterhood-basketball-8ZrrMn','kyrie-7-ep-sisterhood-basketball-shoe-8ZrrMn.jpg',10,2300000,'New',6,1),
('Giay_kyrie-7-older-basketball-TWXH33','kyrie-7-older-basketball-shoe-TWXH33.jpg',10,2100000,'New',6,1),
('Giay_kyrie-flytrap-3-ep-basketball-0qb5vw','kyrie-flytrap-3-ep-basketball-shoe-0qb5vw.jpg',49,2000000,'New',6,2),
('Giay_kyrie-flytrap-3-older-basketball-Sckj9R','kyrie-flytrap-3-older-basketball-shoe-Sckj9R.jpg',10,2500000,'New',6,1),
('Giay_kyrie-flytrap-3-se-younger-Sg2B2v','kyrie-flytrap-3-se-younger-shoe-Sg2B2v.jpg',22,3800000,'New',6,3),
('Giay_kyrie-flytrap-4-younger-Ql4XVQ','kyrie-flytrap-4-younger-shoe-Ql4XVQ.jpg',23,3300000,'New',6,3),
('Giay_kyrie-low-3-ep-basketball-H1bKPR','kyrie-low-3-ep-basketball-shoe-H1bKPR.jpg',22,2200000,'New',6,2),
('Giay_SUPERSTAR_SLIP_ON_DJen_FW7051','SUPERSTAR_SLIP_ON_DJen_FW7051_01_standard.jpg',10,1100000,'New',6,1),
('Giay_X9000L4_CYBERPUNK_2077_FY3143','X9000L4_CYBERPUNK_2077_trang_FY3143_01_standard.jpg',10,1000000,'New',6,1),

('Tat_Trefoil_Liner_DJen_S20274','3_djoi_tat_Trefoil_Liner_DJen_S20274_03_standard.jpg',10,200000,'New',7,1),
('Tat_Trefoil_Liner_FT8524','3_djoi_tat_Trefoil_Liner_trang_FT8524_03_standard.jpg',23,230000,'New',7,2),
('Tat_Trefoil_Liner_S20273','3_djoi_tat_Trefoil_Liner_trang_S20273_03_standard.jpg',23,180000,'New',7,3),
('Tat_academy-over-calf-football-socks-3LZwVZ','academy-over-calf-football-socks-3LZwVZ.jpg',26,170000,'New',7,3),
('Tat_DJen_FM0677','Bo_3_djoi_tat_an_DJen_FM0677_03_standard.jpg',14,150000,'New',7,2),
('Tat_DJen_FM0643','Bo_3_djoi_tat_co_trung_DJen_FM0643_03_standard.jpg',10,130000,'New',7,1),
('Tat_FT8529','Bo_3_djoi_tat_co_trung_trang_FT8529_03_standard.jpg',22,150000,'New',7,2),
('Tat_DJen_DZ9357','Bo_3_djoi_tat_djem_co_trung_DJen_DZ9357_03_standard.jpg',60,110000,'New',7,3),
('Tat_brooklyn-nets-city-edition-elite-nba-crew-mL68m8','brooklyn-nets-city-edition-elite-nba-crew-socks-mL68m8.jpg',23,170000,'New',7,2),
('Tat_elite-basketball-crew-64wjk3','elite-basketball-crew-socks-64wjk3.jpg',14,138000,'New',7,1),
('Tat_elite-cushioned-no-show-running-s4WQq7','elite-cushioned-no-show-running-socks-s4WQq7.jpg',10,180000,'New',7,1),
('Tat_everyday-cushioned-training-ankle-DVHzV6','everyday-cushioned-training-ankle-socks-DVHzV6.jpg',14,190000,'New',7,3),
('Tat_everyday-cushioned-training-crew-gSdsFg','everyday-cushioned-training-crew-socks-gSdsFg.jpg',14,160000,'New',7,2),
('Tat_everyday-cushioned-training-low-VNb5d4','everyday-cushioned-training-low-socks-VNb5d4.jpg',14,140000,'New',7,3),
('Tat_everyday-cushioned-training-no-show-R1C77V','everyday-cushioned-training-no-show-socks-R1C77V.jpg',22,130000,'New',7,1),
('Tat_everyday-cushioned-training-no-show-R1C77V','everyday-cushioned-training-no-show-socks-R1C77V.jpg',10,100000,'New',7,2),
('Tat_everyday-plus-lightweight-training-footie-jnTpnnXR','everyday-plus-lightweight-training-footie-socks-jnTpnnXR.jpg',10,150000,'New',7,1),
('Tat_jordan-everyday-max-crew-zxPAlg','jordan-everyday-max-crew-socks-zxPAlg.jpg',10,170000,'New',7,1),
('Tat_jordan-everyday-max-no-show-PXBN4g','jordan-everyday-max-no-show-socks-PXBN4g.jpg',10,120000,'New',7,3),
('Tat_jordan-legacy-ugly-sweater-crew-5zxV5M','jordan-legacy-ugly-sweater-crew-socks-5zxV5M.jpg',14,110000,'New',7,3),
('Tat_kyrie-elite-basketball-crew-wsMxBG','kyrie-elite-basketball-crew-socks-wsMxBG.jpg',11,190000,'New',7,2),
('Tat_liverpool-fc-2020-21-stadium-home-over-calf-football-FCTJs3','liverpool-fc-2020-21-stadium-home-over-calf-football-socks-FCTJs3.jpg',10,230000,'New',7,2),
('Tat_MILANO_16_SOCK_AJ5907','MILANO_16_SOCK_Mau_xanh_da_troi_AJ5907_03_standard.jpg',60,210000,'New',7,3),
('Tat_MILANO_16_SOCK_AJ5905','MILANO_16_SOCK_trang_AJ5905_03_standard.jpg',22,220000,'New',7,1),
('Tat_multiplier-running-ankle-mLLjFH','multiplier-running-ankle-socks-mLLjFH.jpg',10,230000,'New',7,3),
('Tat_multiplier-running-no-show-NnCbVV','multiplier-running-no-show-socks-NnCbVV.jpg',20,280000,'New',7,2),
('Tat_sb-everyday-max-lightweight-skate-crew-gp3khL','sb-everyday-max-lightweight-skate-crew-socks-gp3khL.jpg',10,290000,'New',7,1),
('Tat_sneakr-sox-ankle-CRvSzr','sneakr-sox-ankle-socks-CRvSzr.jpg',26,300000,'New',7,1),
('Tat_sportswear-essential-crew-StcqzG','sportswear-essential-crew-socks-StcqzG.jpg',10,260000,'New',7,2),
('Tat_sportswear-everyday-essential-crew-VntVlJ','sportswear-everyday-essential-crew-socks-VntVlJ.jpg',10,200000,'New',7,3),
('Tat_squad-crew-pfskHc','squad-crew-socks-pfskHc.jpg',22,150000,'New',7,1),
('Tat_Alphaskin_DJen_FK0962','Tat_co_chan_Alphaskin_DJen_FK0962_03_standard.jpg',27,150000,'New',7,2),
('Tat_Basic_FM3128','Tat_co_chan_Basic_trang_FM3128_03_standard.jpg',22,140000,'New',7,1),
('Tat_Alphaskin_FK0957','Tat_co_thap_Alphaskin_trang_FK0957_03_standard.jpg',27,130000,'New',7,3),
('Tat_DJen_FM3134','Tat_co_thap_DJen_FM3134_03_standard.jpg',60,110000,'New',7,2),
('Tat_Trefoil_DJen_EE1151','Tat_Trefoil_cao_djen_co_chan_3_djoi_DJen_EE1151_03_standard.jpg',10,180000,'New',7,1),
('Tat_Trefoil_EE1152','Tat_Trefoil_cao_djen_co_chan_3_djoi_trang_EE1152_03_standard.jpg',26,199000,'New',7,2),

('LG BX 4K Smart OLED TV','LG BX 4K Smart OLED TV.jpg',22,55900000,'New',8,3),
('LG CX 4K Smart OLED TV','LG CX 4K Smart OLED TV.jpg',10,76300000,'New',8,2),
('LG LED TV','LG LED TV.jpg',26,65300000,'New',8,1),
('LG SMART TV','LG SMART TV.jpg',14,75200000,'New',8,1),
('LG UN74 4K Smart UHD TV','LG UN74 4K Smart UHD TV.jpg',27,83200000,'New',8,2),
('LG ZX 8K SIGNATURE OLED TV','LG ZX 8K SIGNATURE OLED TV.jpg',11,65100000,'New',8,1),
('TV LG 8K NanoCell','TV LG 8K NanoCell.jpg',26,99300000,'New',8,3);


