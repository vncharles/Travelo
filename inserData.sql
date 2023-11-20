
INSERT INTO Role (name, description) values 
('ROLE_ADMIN', 'admin'), 
('ROLE_USER', 'user'), 
('ROLE_STAFF', 'staff');

INSERT INTO t_user (active, email, password, role_id) values
(true, 'admin@gmail.com', '$2a$10$J.22iiKQx2g.QcvYakQP/.grq/ouPl6iZaQfRSUF0ubrUw67JsvOy', 1),
(true, 'staff1@mail.comm', '$2a$10$ks2E4mEb.4yxhk.L4NipAerpD621eyyqusiiaUFfIXVEO8HsTN2W.', 3);


INSERT INTO t_location (province, description) VALUES
('Hà Nội', 'Thủ đô nghìn năm văn hiến, với hệ thống di tích lịch sử và văn hóa phong phú.'),
('Hồ Chí Minh', 'Thành phố sôi động, nơi giao thoa văn hóa và kinh tế.'),
('Đà Nẵng', 'Thành phố trẻ trung, hiện đại, nơi giao thoa giữa văn hóa truyền thống và sự phồn thịnh của thành phố phát triển.'),
('Cần Thơ', 'Thành phố nằm ở trung tâm Đồng Bằng Sông Cửu Long, nổi tiếng với cảnh đẹp hùng vĩ của dòng sông và hệ sinh thái động và cây xanh.'),
('Lào Cai', 'Nơi nằm dưới chân núi Fansipan, với cảnh đẹp hữu tình và đồng bằng lúa mạch rộng lớn.'),
('Quảng Ninh', 'Thành phố nổi tiếng với vịnh Hạ Long, một trong những kỳ quan tự nhiên của thế giới.'),
('Đắk Lắk', 'Vùng đất của những người dân Ê Đê, với cộng đồng văn hóa độc đáo và thiên nhiên hùng vĩ.'),
('Nha Trang', 'Thành phố biển nổi tiếng với bãi biển dài và nước biển trong xanh.'),
('Vũng Tàu', 'Thành phố ven biển gần TP.Hồ Chí Minh, nổi tiếng với cảnh đẹp và các bãi biển tuyệt vời.'),
('Huế', 'Thành phố cổ kính nằm giữa các triền núi và biển, nổi tiếng với di sản văn hóa độc đáo.'),
('Phú Quốc', 'Hòn đảo ngọc xinh đẹp, với bãi biển dịu dàng và hệ sinh thái biển độc đáo.'),
('Đà Lạt', 'Thành phố ngàn hoa, với khí hậu mát mẻ và cảnh đẹp nên thơ.'),
('Sapa', 'Thị trấn nằm giữa những ngọn núi hùng vĩ, nổi tiếng với những thửa ruộng bậc thang tuyệt vời.'),
('Hội An', 'Phố cổ Hội An với những ngôi nhà cổ, cầu ánh sáng lãng mạn và ẩm thực phong phú.'),
('Cẩm Ranh', 'Vịnh Cam Ranh nổi tiếng với bãi biển dài và biển xanh biếc.'),
('Tam Đảo', 'Thị trấn núi Tam Đảo với khí hậu se lạnh và cảnh đẹp thiên nhiên hùng vĩ.'),
('Cô Tô', 'Đảo Cô Tô xinh đẹp, với bãi biển trong xanh và đồng cỏ xanh mướt.'),
('Buôn Ma Thuột', 'Thành phố cà phê nằm giữa vùng cao nguyên đồng bằng Sông Cửu Long.'),
('Cần Giờ', 'Quận Cần Giờ, nơi gặp gỡ giữa sông nước và thiên nhiên hoang dã.');


INSERT INTO t_tour_info (name, description, itinerary, create_at, price, location_id) VALUES
('Khám Phá Vịnh Hạ Long và Quảng Ninh', 'Hành trình tới vùng đất Quảng Ninh, trải nghiệm vịnh Hạ Long huyền bí, thăm các hang động kỳ diệu, và khám phá văn hóa độc đáo của người dân địa phương.', '07:30-12:00 Xe cùng hướng dẫn viên đón khách tại khách sạn khởi hành đi thăm Vịnh Hạ Long.
12:00-12:15 Quý khách đến bến cảng tàu Hạ Long và làm thủ tục lên tàu.
12:15-14:00 Tàu rời bến bắt đầu chuyến thăm quan du ngoạn Vịnh Hạ Long, tàu sẽ đi ngang qua các hòn đá lớn nhỏ với tên gọi đặc biệt như: Hòn Gà Chọi, hòn Chó Đá, hòn Đỉnh Hương. 
Quý khách dùng bữa cơm trưa trên tàu. 
14:00-16:30 Quý khách thăm quan Hang Sửng Sốt, một trong những hang động đẹp nhất vịnh Hạ Long. Tiếp đó, tàu di chuyển đến Hang Luồn, du khách có thể chèo kayak/đò hoặc nghỉ ngơi trên tàu. 
Tiếp theo, tàu sẽ đưa khách đến với đảo Ti Top. Quý khách có thể tắm biển tại bãi tắm TiTop với bãi cát trắng, hoặc trekking leo lên đỉnh núi Ti Top ngắm nhìn toàn cảnh Vịnh Hạ Long. 
16:30-18:00 Quay trở lại tàu để khởi hành về lại cảng Hạ Long. Quý khách có thể nghe nhạc và thư giãn trên boong tàu, hòa mình vào thiên nhiên. 
18:00-21:30 Tàu cập bến. Chia tay nhà tàu và lên xe về Hà Nội. Kết thúc tour.', '2023-01-01', 7500000, 6),
('Thác Bản Giốc và Lạng Sơn', 'Khám phá vẻ đẹp hùng vĩ của thác Bản Giốc, thưởng thức ẩm thực đặc sắc tại Lạng Sơn, và trải nghiệm văn hóa của người dân địa phương.', '06:00-10:00 Xe và hướng dẫn viên đón khách tại điểm hẹn, khởi hành đi thác Bản Giốc.
10:00-12:00 Thăm quan thác Bản Giốc, tận hưởng không khí tươi mới và hùng vĩ của thiên nhiên. 
12:00-13:30 Dùng trưa tại nhà hàng địa phương với các món ăn ngon đặc sản vùng miền.
13:30-15:00 Tiếp tục hành trình đến Lạng Sơn, thăm quan các điểm du lịch lịch sử và văn hóa.
15:00-18:00 Mua sắm đặc sản, đồ handmade tại thị trấn Đồng Đăng.
18:00-21:00 Trở về điểm xuất phát, kết thúc tour.', '2023-02-01', 8000000, 10),
('Miền Tây Đồng Nai và Cuộc Sống Thủy Thủ', 'Du lịch miền Tây, khám phá vùng đồng bằng sông Cửu Long, thăm làng nghề cá truyền thống và trải nghiệm cuộc sống thủy thủ trên sông.', '08:00-12:00 Xe và hướng dẫn viên đón khách tại điểm hẹn, khởi hành đi miền Tây Đồng Nai.
12:00-13:00 Dùng trưa tại quán ẩm thực truyền thống miền Tây.
13:00-15:00 Thăm làng nghề cá, trải nghiệm cuộc sống thủy thủ trên sông và mua sắm đặc sản miền Tây.
15:00-17:00 Tiếp tục hành trình đến Cuộc sống thủy thủ truyền thống, tham gia các hoạt động trải nghiệm và tận hưởng không khí bình yên của vùng quê.
17:00-19:00 Trở về điểm xuất phát, kết thúc tour.', '2023-03-01', 6500000, 4),
('Đà Lạt - Thành phố Ngàn Hoa', 'Hành trình tới thành phố ngàn hoa, trải nghiệm không khí mát mẻ, thăm các khu vườn hoa độc đáo và thưởng thức đặc sản địa phương.', '08:00-12:00 Xe và hướng dẫn viên đón khách tại điểm hẹn, khởi hành đi Đà Lạt.
12:00-13:00 Dùng trưa tại nhà hàng địa phương với các món ăn ngon.
13:00-15:00 Thăm các khu vườn hoa nổi tiếng, chụp ảnh lưu niệm và tận hưởng không khí trong lành của thành phố ngàn hoa.
15:00-17:00 Ghé thăm các địa điểm du lịch nổi tiếng khác của Đà Lạt.
17:00-19:00 Trở về điểm xuất phát, kết thúc tour.', '2023-04-01', 7000000, 11),
('Hành Trình Quy Nhơn và Biển Trung', 'Khám phá vẻ đẹp của bờ biển Quy Nhơn, thăm các di tích lịch sử, và thưởng thức ẩm thực độc đáo của vùng miền.', '07:00-12:00 Xe và hướng dẫn viên đón khách tại điểm hẹn, khởi hành đi Quy Nhơn.
12:00-13:00 Dùng trưa tại nhà hàng địa phương với các món biển tươi ngon.
13:00-15:00 Thăm các điểm du lịch nổi tiếng tại Quy Nhơn, như Chùa Đổng Cốc, Bãi Xep, Eo Gió.
15:00-17:00 Tận hưởng thời gian tự do tại bãi biển Ky Co, tắm biển và thư giãn.
17:00-19:00 Trở về điểm xuất phát, kết thúc tour.', '2023-05-01', 7200000, 13),
('Thành Phố Cà Phê Buôn Ma Thuột', 'Hành trình tới Buôn Ma Thuột, thăm các vườn cà phê nổi tiếng, trải nghiệm cuộc sống của người dân địa phương và thưởng thức cà phê ngon.', 
'07:30-12:00 Xe và hướng dẫn viên đón khách tại khách sạn. Khởi hành đi thăm các vườn cà phê nổi tiếng ở Buôn Ma Thuột.
12:00-13:00 Dùng trưa tại nhà hàng địa phương, thưởng thức các món ăn ngon.
13:00-15:30 Tiếp tục hành trình thăm các điểm du lịch và vườn cà phê khác nhau, tìm hiểu quy trình chế biến cà phê.
15:30-17:00 Thăm các cửa hàng trưng bày và mua sắm cà phê đặc sản.
17:00-18:00 Trở về khách sạn và kết thúc chương trình.', '2023-06-01', 8900000, 18),
('Đảo Ngọc Phú Quốc', 'Khám phá vẻ đẹp của đảo Phú Quốc, trải nghiệm bãi biển dịu dàng, tham gia các hoạt động giải trí và thưởng thức hải sản tươi ngon.', 
'08:00-12:00 Di chuyển đến đảo Phú Quốc và kiểm tra phòng tại khách sạn.
12:00-13:00 Dùng trưa tại nhà hàng ven biển.
13:00-15:30 Thăm quan các điểm du lịch trên đảo như Dinh Cậu, Suối Tranh, và Dinh Thự Ông Địa.
15:30-18:00 Tự do tận hưởng thời gian tại bãi biển hoặc tham gia các hoạt động giải trí.
18:00-20:00 Dùng tối và thưởng thức các món hải sản tại nhà hàng địa phương.
20:00-22:00 Tự do khám phá cuộc sống về đêm trên đảo.', '2023-07-01', 9500000, 12),
('Lễ Hội Ánh Sáng Đà Nẵng', 'Tham gia lễ hội ánh sáng tại thành phố Đà Nẵng, ngắm nhìn những tác phẩm nghệ thuật ánh sáng độc đáo và thưởng thức ẩm thực đặc sản.', 
'18:00-19:30 Hướng dẫn viên đón khách tại điểm hẹn và khám phá các khu vực trung tâm của thành phố Đà Nẵng.
19:30-21:00 Tham quan lễ hội ánh sáng với các triển lãm nghệ thuật, đèn LED sáng tạo trên cầu Rồng và các con đường trung tâm.
21:00-22:30 Dùng tối tại một nhà hàng địa phương và thưởng thức các món ăn đặc sản.
22:30 Kết thúc chương trình, hướng dẫn viên đưa du khách trở về khách sạn hoặc điểm hẹn.', '2023-08-01', 7800000, 3),
('Châu Đốc - Miền Tây Sông Nước', 'Khám phá vùng đất Châu Đốc, thăm khu du lịch Thạch Anh và trải nghiệm cuộc sống ven sông nước.', 
'07:00-12:00 Hướng dẫn viên và phương tiện đưa đoàn đi thăm khu du lịch Thạch Anh và các điểm du lịch nổi tiếng khác.
12:00-13:00 Dùng trưa tại nhà hàng ven sông.
13:00-15:30 Tiếp tục thăm quan các điểm du lịch khác và thưởng thức cảnh đẹp ven sông.
15:30-17:00 Trở về trung tâm thị trấn, tự do mua sắm và thăm quan.
17:00-18:00 Trở về khách sạn và kết thúc chương trình.', '2023-09-01', 6900000, 7),
('Vùng Cao Núi Đà Lạt', 'Hành trình tới vùng cao núi Đà Lạt, thăm những thửa ruộng bậc thang tuyệt vời, và trải nghiệm không khí trong lành của núi rừng.', 
'08:00-12:00 Xe và hướng dẫn viên đưa du khách đi thăm những khu vườn đặc sản, thể hiện nét đẹp của vùng núi Đà Lạt.
12:00-13:00 Dùng trưa tại nhà hàng địa phương.
13:00-15:30 Tiếp tục hành trình thăm các điểm du lịch nổi tiếng như thác Prenn, thác Datanla, và làng hoa Đà Lạt.
15:30-17:00 Tự do mua sắm và thưởng thức đặc sản địa phương.
17:00-18:00 Trở về khách sạn và kết thúc chương trình.', '2023-10-01', 7200000, 12),
('Chùa Một Cột và Hà Nội Cổ', 'Hành trình khám phá thủ đô Hà Nội với chùa Một Cột lịch sử, phố cổ Hà Nội, và trải nghiệm ẩm thực đặc sắc.', 
'08:30-12:00 Hướng dẫn viên và xe đưa khách khám phá các điểm du lịch lịch sử như chùa Một Cột, Văn Miếu - Quốc Tử Giám.
12:00-13:00 Dùng trưa tại nhà hàng phục vụ đặc sản Hà Nội.
13:00-15:30 Thăm các phố cổ nổi tiếng như Hàng Bè, Hàng Gai và thưởng thức trà đá tại quán cà phê cổ.
15:30-17:00 Thăm quan các cửa hàng đồ handmade và mua sắm đặc sản vùng miền.
17:00-18:00 Trở về khách sạn và kết thúc chương trình.', '2023-11-01', 6800000, 1),
('Vịnh Cam Ranh và Biển Nha Trang', 'Khám phá vẻ đẹp tự nhiên của vịnh Cam Ranh, thư giãn tại bãi biển Nha Trang và thưởng thức các món hải sản tươi ngon.', 
'07:30-12:00 Xe và hướng dẫn viên đón khách tại khách sạn và khởi hành đi vịnh Cam Ranh.
12:00-13:00 Dùng trưa tại nhà hàng ven biển.
13:00-15:30 Thăm quan các điểm đẹp nổi tiếng như đảo Hòn Mun, bãi Ngọc Hồi, và nhảy dù tại đỉnh núi Cô Tiên.
15:30-17:00 Tự do thư giãn tại bãi biển Nha Trang hoặc tham gia các hoạt động giải trí.
17:00-18:00 Trở về khách sạn và kết thúc chương trình.', '2023-12-01', 7800000, 15),
('Miền Đông Sài Gòn và Làng Nghề Cổ', 'Du lịch miền Đông, thăm thành phố Hồ Chí Minh, khám phá làng nghề truyền thống và thưởng thức ẩm thực độc đáo.', 
'07:00-09:00 Xe và hướng dẫn viên đón khách tại khách sạn, khởi hành đi thăm miền Đông.
09:00-11:30 Thăm những điểm du lịch nổi tiếng như Dinh Thống Nhất, Nhà thờ Đức Bà và Bưu điện Trung tâm Sài Gòn.
11:30-13:00 Dùng trưa tại nhà hàng địa phương, thưởng thức ẩm thực miền Nam.
13:00-15:00 Tiếp tục chuyến đi đến làng nghề truyền thống, trải nghiệm các công đoạn làm nghề truyền thống và mua sắm các sản phẩm độc đáo.
15:00-18:00 Quay về trung tâm, thời gian tự do mua sắm hoặc thăm các khu vui chơi giải trí.
18:00 Trở về khách sạn, kết thúc chương trình.', '2024-01-01', 7200000, 2),
('Hành Trình Sapa và Fansipan', 'Khám phá vùng núi Sapa, leo lên đỉnh Fansipan cao nhất Việt Nam, và trải nghiệm văn hóa dân dụ nơi đây. Đắm chìm trong cảnh đẹp thiên nhiên hùng vĩ, với những thửa ruộng bậc thang xanh mướt màu mỡ. Đây là cơ hội tuyệt vời để khám phá và hiểu rõ hơn về đời sống và văn hóa của các dân tộc thiểu số.', 
'06:00-12:00 Xe và hướng dẫn viên đón khách tại khách sạn, khởi hành đi Sapa.
12:00-13:00 Dùng trưa tại nhà hàng địa phương, thưởng thức ẩm thực đặc sắc của vùng miền.
13:00-15:30 Thăm làng dân tộc, khám phá thị trấn Sapa và trải nghiệm cuộc sống văn hóa độc đáo.
15:30-17:00 Dùng trưa tại nhà hàng địa phương và nghỉ ngơi.
17:00-21:00 Dẫn đoàn lên đỉnh Fansipan, tận hưởng cảnh hoàng hôn tuyệt vời từ đỉnh núi.
21:00 Xuống núi và trở về khách sạn, kết thúc chương trình.', '2024-02-01', 8500000, 12),
('Đảo Cô Tô - Hòn Ngọc Viễn Đông', 'Hành trình tới đảo Cô Tô, khám phá bãi biển đẹp, tham gia các hoạt động nghệ thuật và thưởng thức hải sản tươi ngon. Du khách sẽ được trải nghiệm cuộc sống thư giãn giữa không gian biển xanh biếc và không khí trong lành.', 
'06:00-08:00 Xe và hướng dẫn viên đón khách tại khách sạn, khởi hành đi Cô Tô.
08:00-10:00 Đến Cô Tô, check-in khách sạn và nghỉ ngơi.
10:00-12:00 Thăm quan bãi biển Trắng, tận hưởng không khí trong lành và thủy triều bãi biển.
12:00-14:00 Dùng trưa tại nhà hàng ven biển, thưởng thức hải sản tươi ngon.
14:00-17:00 Thăm các điểm du lịch nổi tiếng như cầu Đôi, đền Cô Tô và khu vực ngọc trai.
17:00-19:00 Thời gian tự do, tận hưởng hoàng hôn trên bãi biển.
19:00-21:00 Dùng tối và thư giãn tại nhà hàng, trải nghiệm không khí độc đáo của đảo Cô Tô.
21:00 Trở về khách sạn, kết thúc chương trình.', '2024-03-01', 9200000, 16),
('Chùa Linh Ứng - Ngũ Hành Sơn', 'Thăm chùa Linh Ứng, khám phá ngũ ngọn núi đá Non Nước, và tận hưởng không khí tĩnh lặng và linh thiêng. Tour này là cơ hội để du khách tìm hiểu về lịch sử, kiến trúc tâm linh của Việt Nam và thưởng thức phong cảnh thiên nhiên hùng vĩ.', 
'08:00-10:00 Xe và hướng dẫn viên đón khách tại khách sạn, khởi hành đi Ngũ Hành Sơn.
10:00-12:00 Thăm chùa Linh Ứng, tìm hiểu về lịch sử và kiến trúc độc đáo của ngôi chùa nằm giữa bãi biển Non Nước.
12:00-13:30 Dùng trưa tại nhà hàng địa phương, thưởng thức ẩm thực đặc sắc.
13:30-15:30 Thăm các ngọn núi đá Non Nước, tận hưởng không gian tĩnh lặng và phong cảnh thiên nhiên hùng vĩ.
15:30-17:00 Thời gian tự do mua sắm và tận hưởng không khí biển tại bãi biển Non Nước.
17:00 Trở về khách sạn, kết thúc chương trình.', '2024-04-01', 7100000, 3),
('Du Lịch Biển Vũng Tàu - Hòn Ba', 'Tham gia tour du lịch biển Vũng Tàu, tận hưởng bãi biển dịu dàng và thăm đảo Hòn Ba hoang sơ. Đây là hành trình lý tưởng cho những người yêu thích biển cả và muốn trải nghiệm cuộc sống gần gũi với thiên nhiên.', 
'07:00-09:00 Xe và hướng dẫn viên đón khách tại khách sạn, khởi hành đi Vũng Tàu.
09:00-10:30 Đến Vũng Tàu, thăm quan các điểm du lịch nổi tiếng như tượng Chúa Kitô và đồi Cỏ May.
10:30-12:30 Dùng trưa tại nhà hàng ven biển, thưởng thức hải sản tươi ngon.
12:30-14:30 Du khách thăm quan đảo Hòn Ba, tận hưởng không gian hoang sơ và biển cả mênh mông.
14:30-16:30 Thời gian tự do tận hưởng biển và thư giãn.
16:30 Trở về Hồ Chí Minh, kết thúc chương trình.', '2024-05-01', 8000000, 8),
('Chùa Hương và Ninh Bình', 'Khám phá vùng Ninh Bình, thăm chùa Hương nổi tiếng, và trải nghiệm cảm giác bình yên giữa thiên nhiên tươi mới.', 
'08:00-10:00 Xe và hướng dẫn viên đón khách tại khách sạn, khởi hành đi Ninh Bình.
10:00-11:30 Thăm chùa Hương, một trong những địa điểm tâm linh nổi tiếng tại Việt Nam.
11:30-13:00 Dùng trưa tại nhà hàng địa phương, thưởng thức các món ăn truyền thống.
13:00-15:00 Du khách thăm quan các danh thắng nổi tiếng như đền Thái Vi, hang Múa, và bảo tàng Ninh Bình.
15:00-16:30 Du ngoạn trên sông Ngo Dong, ngắm cảnh đẹp tuyệt vời của thác Tràng An.
16:30 Trở về Hà Nội, kết thúc chương trình.', '2024-06-01', 6900000, 5),
('Du Lịch Biển Vũng Tàu - Hòn Ba', 'Tham gia tour du lịch biển Vũng Tàu, tận hưởng bãi biển dịu dàng và thăm đảo Hòn Ba hoang sơ.', '07:00-08:30: Xe và hướng dẫn viên đến đón khách tại điểm hẹn. Khởi hành đi Vũng Tàu.
08:30-10:30: Đến Vũng Tàu, thăm quan bãi Trước, tận hưởng không khí biển tươi mới.
10:30-12:00: Dùng trưa tại nhà hàng địa phương với các món hải sản tươi ngon.
12:00-14:00: Thăm đảo Hòn Ba, tận hưởng bãi biển hoang sơ và tham gia các hoạt động giải trí trên đảo.
14:00-16:00: Quay về cảng, thăm chùa Niet Ban Tinh Xa và tận hưởng không khí tâm linh tại đây.
16:00-18:00: Tự do thưởng thức đồ uống và mua sắm đặc sản tại khu vực chợ đêm Vũng Tàu.
18:00: Xe đưa khách trở về điểm tập trung. Kết thúc chương trình.', '2024-05-01', 8000000, 8),
('Chùa Hương và Ninh Bình', 'Khám phá vùng Ninh Bình, thăm chùa Hương nổi tiếng, và trải nghiệm cảm giác bình yên giữa thiên nhiên tươi mới.', '08:00-09:00: Xe và hướng dẫn viên đến đón khách tại điểm hẹn. Khởi hành đi Ninh Bình.
09:00-11:00: Thăm quan chùa Hương, tìm hiểu về lịch sử và kiến trúc tâm linh độc đáo.
11:00-12:30: Dùng trưa tại nhà hàng địa phương với các món ăn truyền thống.
12:30-15:00: Thăm hang Múa và thưởng ngoạn cảnh đẹp thiên nhiên hùng vĩ của Ninh Bình.
15:00-17:00: Thăm Tam Cốc và trải nghiệm đò đi chèo dọc theo dòng sông Ngo Dong.
17:00: Xe đưa khách trở về điểm tập trung. Kết thúc chương trình.', '2024-06-01', 6900000, 5),
('Buôn Đôn - Làng Cà Phê Sài Gòn', 'Du lịch Buôn Đôn - thị trấn nổi tiếng với cà phê, thăm các vườn cà phê và trải nghiệm cuộc sống thôn quê.', '06:30-08:30: Xe và hướng dẫn viên đến đón khách tại điểm hẹn. Khởi hành đi Buôn Đôn.
08:30-10:00: Thăm làng cà phê Ea Kao, tìm hiểu về quy trình sản xuất cà phê và thưởng thức cà phê ngon.
10:00-12:30: Thăm làng cư trú truyền thống của đồng bào dân tộc Ede, tìm hiểu về văn hóa và lối sống truyền thống.
12:30-14:00: Dùng trưa tại nhà hàng địa phương với các món ẩm thực đặc sắc.
14:00-16:00: Thăm KDL động vật rừng Yang Bay, tham gia các hoạt động giải trí và thưởng thức không khí trong lành của rừng núi.
16:00: Xe đưa khách trở về điểm tập trung. Kết thúc chương trình.', '2024-07-01', 9200000, 18),
('Hòn Mun - Thiên Đường Dưới Biển', 'Khám phá vùng biển Hòn Mun, thưởng thức đợt san hô đầy màu sắc và tham gia các hoạt động lặn ngắm san hô.', '07:00-09:00: Xe và hướng dẫn viên đến đón khách tại điểm hẹn. Khởi hành đi Nha Trang.
09:00-10:30: Đến cảng Cái Cui, lên thuyền và khám phá Hòn Mun - Khu dự trữ sinh quyển biển đầu tiên tại Việt Nam.
10:30-12:00: Thưởng thức bữa trưa trên thuyền và nghỉ ngơi tại bãi biển đẹp.
12:00-14:30: Thăm khu vực đợt san hô, tham gia lớp học lặn cơ bản (nếu có mong muốn).
14:30-16:00: Thư giãn tại bãi biển và tham gia các hoạt động giải trí khác trên thuyền.
16:00: Thuyền đưa khách trở về cảng và xe đưa về điểm tập trung. Kết thúc chương trình.', '2024-08-01', 9500000, 14),
('Đồng Tháp - Miền Tây Nắng Cháy', 'Du lịch Đồng Tháp, thăm vườn trái cây và di tích lịch sử, trải nghiệm nét đẹp của miền Tây Nắng Cháy. Tour mang đến không gian thoải mái giữa thiên nhiên xanh mát và cơ hội tìm hiểu về nền văn hóa độc đáo của người dân miền Tây.', '07:00-09:00: Xe và hướng dẫn viên đến đón khách tại điểm hẹn. Khởi hành đi Cao Lãnh.
09:00-10:30: Thăm vườn trái cây Cao Lãnh, thưởng thức trái cây tại đây.
10:30-12:30: Thăm di tích lịch sử Khu du lịch lịch sử Văn hóa Đồng Tháp.
12:30-14:00: Dùng trưa tại nhà hàng địa phương với các món ăn miền Tây.
14:00-16:00: Thăm Khu du lịch sinh thái Tràm Chim và tham gia các hoạt động quan sát chim.
16:00: Xe đưa khách trở về điểm tập trung. Kết thúc chương trình.', '2024-09-01', 6900000, 5),
('Thiên Đường Núi Cao Đà Lạt', 'Khám phá vùng cao núi Đà Lạt, trải nghiệm không khí trong lành, ngắm nhìn những cảnh đẹp hữu tình và thưởng thức những loại hoa độc đáo. Hành trình này là lựa chọn tuyệt vời cho những người muốn tránh khỏi khí trời nóng bức của thành phố.', '08:00-10:00: Xe và hướng dẫn viên đến đón khách tại điểm hẹn. Khởi hành đi Đà Lạt.
10:00-12:00: Thăm Thác Prenn và tham gia các hoạt động giải trí tại đây.
12:00-14:00: Dùng trưa tại nhà hàng địa phương với các món ăn truyền thống Đà Lạt.
14:00-16:00: Thăm Vườn hoa Thành phố và thưởng thức không khí mát lành của núi Đà Lạt.
16:00-18:00: Thăm Làng cổ Bản Đôn và tìm hiểu về văn hóa độc đáo của người dân địa phương.
18:00: Xe đưa khách trở về điểm tập trung. Kết thúc chương trình.', '2024-10-01', 7200000, 12),
('Thác Pongour - Đà Nẵng Huyền Bí', 'Thăm thác Pongour, một trong những thác nước hùng vĩ của Việt Nam, và khám phá thành phố Đà Nẵng với những điểm du lịch độc đáo. Hành trình này kết hợp giữa trải nghiệm thiên nhiên và văn hóa đô thị.', '08:00-09:30 Xe và hướng dẫn viên đón khách tại khách sạn, khởi hành đi thác Pongour.
09:30-11:30 Thăm thác Pongour - một trong những thác nước đẹp nhất Việt Nam, cảm nhận sức mạnh hùng vĩ của thiên nhiên.
11:30-13:00 Dùng trưa tại nhà hàng địa phương với các món ăn ngon.
13:00-15:30 Tiếp tục hành trình đến thành phố Đà Nẵng. Thăm các điểm du lịch nổi tiếng như cầu Rồng, bãi biển Mỹ Khê, và chụp hình tại ngôi chùa Linh Ứng.
15:30-17:00 Nghỉ ngơi và mua sắm tại khu vực trung tâm thành phố.
17:00-19:30 Tham gia tour ẩm thực tại chợ đêm Hàn và khám phá không khí sôi động của đèn đỏ Đà Nẵng.
19:30-21:30 Trở về khách sạn và kết thúc hành trình.', '2024-11-01', 7800000, 3),
('Vùng Biển Quảng Bình - Hang Sơn Đoòng', 'Khám phá vùng biển Quảng Bình, trải nghiệm động lớn nhất thế giới - hang Sơn Đoòng và cảm nhận vẻ đẹp hùng vĩ của thiên nhiên tạo nên. Hành trình này là cơ hội tốt để những người yêu thích phiêu lưu và khám phá.', '08:00-09:30 Xe và hướng dẫn viên đón khách tại khách sạn, khởi hành đi vùng biển Quảng Bình.
09:30-11:30 Thăm các bãi biển đẹp như bãi Ngọc Nữ và bãi Đá Nhảy, thưởng thức hải sản tươi ngon.
11:30-13:00 Dùng trưa tại nhà hàng ven biển.
13:00-15:30 Tiếp tục hành trình đến hang Sơn Đoòng. Trải nghiệm cuộc phiêu lưu khám phá hang động kỳ diệu này.
15:30-17:00 Tự do thư giãn tại bãi biển Phong Nha và thưởng thức hoàng hôn trên biển.
17:00-19:30 Trở về khách sạn và kết thúc hành trình.', '2024-12-01', 8500000, 9),
('Chợ Đêm Đà Nẵng - Đèn Đỏ Huyền Bí', 'Tham gia tour chợ đêm Đà Nẵng, khám phá không khí sôi động và huyền bí của đèn đỏ Đà Nẵng. Du khách sẽ được tận hưởng không khí vui vẻ, thưởng thức đặc sản đường phố và trải nghiệm văn hóa giải trí độc đáo.', '16:00-17:30 Hướng dẫn viên đón khách tại khách sạn, khởi hành đi chợ đêm Đà Nẵng.
17:30-19:00 Thăm chợ Hàn với nhiều hàng quán đặc sản, trải nghiệm ẩm thực tại các gian hàng.
19:00-21:00 Khám phá khu vực đèn đỏ Đà Nẵng với các quán bar, cafe và nhà hàng độc đáo.
21:00-21:30 Trở về khách sạn và kết thúc hành trình.', '2025-01-01', 7000000, 3);

INSERT INTO t_tour (create_at, start_date, end_date, price, stock, tour_info_id) VALUES
('2023-01-01', '2023-02-01 08:00:00', '2023-02-10 18:00:00', 7500000, 20, 1),
('2023-01-02', '2023-02-05 10:00:00', '2023-02-15 20:00:00', 8000000, 15, 2),
('2023-01-03', '2023-02-10 09:00:00', '2023-02-20 17:00:00', 7200000, 25, 3),
('2023-01-04', '2023-02-15 12:00:00', '2023-02-25 22:00:00', 9000000, 18, 4),
('2023-01-05', '2023-02-20 14:00:00', '2023-03-01 23:00:00', 7800000, 22, 5),
('2023-01-06', '2023-03-01 08:30:00', '2023-03-10 18:30:00', 8200000, 17, 6),
('2023-01-07', '2023-03-05 11:30:00', '2023-03-15 21:30:00', 7600000, 23, 7),
('2023-01-08', '2023-03-10 10:00:00', '2023-03-20 20:00:00', 8800000, 16, 8),
('2023-01-09', '2023-03-15 13:00:00', '2023-03-25 23:00:00', 9200000, 19, 9),
('2023-01-10', '2023-03-20 15:30:00', '2023-04-01 01:30:00', 8000000, 21, 10),
('2023-01-11', '2023-04-05 08:00:00', '2023-04-15 18:00:00', 7800000, 20, 11),
('2023-01-12', '2023-04-10 10:00:00', '2023-04-20 20:00:00', 8500000, 15, 12),
('2023-01-13', '2023-04-15 09:00:00', '2023-04-25 17:00:00', 7200000, 25, 13),
('2023-01-14', '2023-04-20 12:00:00', '2023-04-30 22:00:00', 9200000, 18, 14),
('2023-01-15', '2023-04-25 14:00:00', '2023-05-01 23:00:00', 8000000, 22, 15),
('2023-01-16', '2023-05-01 08:30:00', '2023-05-10 18:30:00', 8600000, 17, 16),
('2023-01-17', '2023-05-05 11:30:00', '2023-05-15 21:30:00', 7900000, 23, 17),
('2023-01-18', '2023-05-10 10:00:00', '2023-05-20 20:00:00', 9300000, 16, 18),
('2023-01-19', '2023-05-15 13:00:00', '2023-05-25 23:00:00', 9800000, 19, 19),
('2023-01-20', '2023-05-20 15:30:00', '2023-06-01 01:30:00', 8200000, 21, 20),
('2023-01-01', '2023-02-01 08:00:00', '2023-02-10 18:00:00', 9000000, 20, 1),
('2023-02-15', '2023-03-15 09:30:00', '2023-03-25 17:30:00', 12000000, 15, 2),
('2023-04-01', '2023-05-01 10:00:00', '2023-05-10 16:00:00', 15000000, 25, 3),
('2023-06-01', '2023-07-01 08:45:00', '2023-07-10 14:45:00', 11000000, 18, 4),
('2023-08-01', '2023-09-01 11:15:00', '2023-09-10 19:15:00', 13000000, 22, 5),
('2023-10-01', '2023-11-01 07:30:00', '2023-11-10 15:30:00', 10000000, 17, 6),
('2023-12-01', '2024-01-01 12:30:00', '2024-01-10 20:30:00', 18000000, 30, 7),
('2024-02-01', '2024-03-01 13:45:00', '2024-03-10 21:45:00', 16000000, 28, 8),
('2024-04-01', '2024-05-01 14:20:00', '2024-05-10 22:20:00', 14000000, 23, 9),
('2024-06-01', '2024-07-01 15:10:00', '2024-07-10 23:10:00', 17000000, 27, 10);

INSERT INTO t_staff (name, email, phone, person_id, address, gender, birthday) VALUES
('Nguyễn Văn A', 'nguyenvana@example.com', '0987654321', 'CMND123456', 'Hà Nội', true, '1990-01-01'),
('Trần Thị B', 'tranthib@example.com', '0123456789', 'CMND789012', 'Hồ Chí Minh', false, '1992-03-15'),
('Lê Văn C', 'levanc@example.com', '0909090909', 'CMND345678', 'Đà Nẵng', true, '1988-07-20'),
('Phạm Thị D', 'phamthid@example.com', '0999888777', 'CMND567890', 'Hải Phòng', false, '1995-05-10'),
('Hoàng Văn E', 'hoangve@example.com', '0888777666', 'CMND123789', 'Quảng Ninh', true, '1998-11-30'),
('Đỗ Thị F', 'dothif@example.com', '0777666555', 'CMND678901', 'Thanh Hóa', false, '1985-12-25'),
('Nguyễn Văn G', 'nguyenvang@example.com', '0666555444', 'CMND234567', 'Nghệ An', true, '1993-09-08'),
('Lý Thị H', 'lythih@example.com', '0555444333', 'CMND890123', 'Hà Tĩnh', false, '1987-06-18'),
('Trương Văn I', 'truongvani@example.com', '0444333222', 'CMND456789', 'Thừa Thiên-Huế', true, '1991-04-03'),
('Mai Thị K', 'maithik@example.com', '0333222111', 'CMND678901', 'Bình Định', false, '1989-02-14'),
('Vũ Văn L', 'vuvanl@example.com', '0222111000', 'CMND123456', 'Đắk Lắk', true, '1994-08-28'),
('Hồ Thị M', 'hothim@example.com', '0111000888', 'CMND789012', 'Cần Thơ', false, '1997-10-05'),
('Đặng Văn N', 'dangvann@example.com', '0999888777', 'CMND345678', 'Vĩnh Long', true, '1986-03-12'),
('Lê Thị O', 'lethio@example.com', '0888777666', 'CMND567890', 'Long An', false, '1999-07-22'),
('Phan Văn P', 'phanvanp@example.com', '0777666555', 'CMND123789', 'Kiên Giang', true, '1992-05-15'),
('Ngô Thị Q', 'nothiq@example.com', '0666555444', 'CMND678901', 'Bình Thuận', false, '1988-09-02'),
('Bùi Văn R', 'buivanr@example.com', '0555444333', 'CMND890123', 'Cà Mau', true, '1995-11-17'),
('Võ Thị S', 'vothis@example.com', '0444333222', 'CMND456789', 'Bà Rịa-Vũng Tàu', false, '1984-01-09'),
('Châu Văn T', 'chauvant@example.com', '0333222111', 'CMND678901', 'Bắc Giang', true, '1993-06-23'),
('Hoàng Thị U', 'hoangthiu@example.com', '0222111000', 'CMND123456', 'Đồng Nai', false, '1989-04-13'),
('Nguyễn Văn X', 'nguyenvanx@example.com', '0111000888', 'CMND789012', 'Sóc Trăng', true, '1994-12-01'),
('Trần Thị Y', 'tranthiy@example.com', '0999888777', 'CMND345678', 'An Giang', false, '1991-08-09'),
('Phạm Văn Z', 'phamvanz@example.com', '0888777666', 'CMND567890', 'Tiền Giang', true, '1987-02-27'),
('Lê Thị W', 'lethiw@example.com', '0777666555', 'CMND123789', 'Hậu Giang', false, '1998-10-19'),
('Mai Văn J', 'maivanj@example.com', '0666555444', 'CMND678901', 'Bắc Ninh', true, '1985-07-03'),
('Vũ Thị X', 'vuthix@example.com', '0555444333', 'CMND890123', 'Hải Dương', false, '1996-09-14'),
('Đỗ Văn Z', 'dovanz@example.com', '0444333222', 'CMND456789', 'Nam Định', true, '1988-05-26'),
('Nguyễn Thị A', 'nguyenthia@example.com', '0333222111', 'CMND678901', 'Thái Bình', false, '1997-01-31'),
('Phan Văn B', 'phanvanb@example.com', '0222111000', 'CMND123456', 'Ninh Bình', true, '1986-11-11');


INSERT INTO t_customer (name, email, phone, address) VALUES
('Nguyễn Văn A', 'nguyenvana@example.com', '0987654321', 'Hà Nội'),
('Trần Thị B', 'tranthib@example.com', '0123456789', 'Hồ Chí Minh'),
('Lê Văn C', 'levanc@example.com', '0909090909', 'Đà Nẵng'),
('Phạm Thị D', 'phamthid@example.com', '0999888777', 'Hải Phòng'),
('Hoàng Văn E', 'hoangve@example.com', '0888777666', 'Quảng Ninh'),
('Đỗ Thị F', 'dothif@example.com', '0777666555', 'Thanh Hóa'),
('Nguyễn Văn G', 'nguyenvang@example.com', '0666555444', 'Nghệ An'),
('Lý Thị H', 'lythih@example.com', '0555444333', 'Hà Tĩnh'),
('Trương Văn I', 'truongvani@example.com', '0444333222', 'Thừa Thiên-Huế'),
('Mai Thị K', 'maithik@example.com', '0333222111', 'Bình Định'),
('Vũ Văn L', 'vuvanl@example.com', '0222111000', 'Đắk Lắk'),
('Hồ Thị M', 'hothim@example.com', '0111000888', 'Cần Thơ'),
('Đặng Văn N', 'dangvann@example.com', '0999888777', 'Vĩnh Long'),
('Lê Thị O', 'lethio@example.com', '0888777666', 'Long An'),
('Phan Văn P', 'phanvanp@example.com', '0777666555', 'Kiên Giang'),
('Ngô Thị Q', 'nothiq@example.com', '0666555444', 'Bình Thuận'),
('Bùi Văn R', 'buivanr@example.com', '0555444333', 'Cà Mau'),
('Võ Thị S', 'vothis@example.com', '0444333222', 'Bà Rịa-Vũng Tàu'),
('Châu Văn T', 'chauvant@example.com', '0333222111', 'Bắc Giang'),
('Hoàng Thị U', 'hoangthiu@example.com', '0222111000', 'Đồng Nai'),
('Nguyễn Văn X', 'nguyenvanx@example.com', '0111000888', 'Sóc Trăng'),
('Trần Thị Y', 'tranthiy@example.com', '0999888777', 'An Giang'),
('Phạm Văn Z', 'phamvanz@example.com', '0888777666', 'Tiền Giang'),
('Lê Thị W', 'lethiw@example.com', '0777666555', 'Hậu Giang'),
('Mai Văn J', 'maivanj@example.com', '0666555444', 'Bắc Ninh'),
('Vũ Thị X', 'vuthix@example.com', '0555444333', 'Hải Dương'),
('Đỗ Văn Z', 'dovanz@example.com', '0444333222', 'Nam Định'),
('Nguyễn Thị A', 'nguyenthia@example.com', '0333222111', 'Thái Bình'),
('Phan Văn B', 'phanvanb@example.com', '0222111000', 'Ninh Bình');

INSERT INTO t_booking (number_person, status, total_price, customer_id, staff_id, tour_id) VALUES
(5, 'PAID', 15000000, 1, 11, 21),
(3, 'UNPAID', 9000000, 2, 12, 22),
(6, 'DONE', 18000000, 3, 13, 23),
(4, 'CANCEL', 12000000, 4, 14, 24),
(2, 'PAID', 6000000, 5, 15, 25),
(5, 'UNPAID', 15000000, 6, 16, 26),
(3, 'DONE', 9000000, 7, 17, 27),
(6, 'CANCEL', 18000000, 8, 18, 28),
(4, 'PAID', 12000000, 9, 16, 29),
(2, 'UNPAID', 6000000, 10, 6, 30),
(5, 'DONE', 15000000, 11, 15, 1),
(3, 'CANCEL', 9000000, 12, 2, 2),
(6, 'PAID', 18000000, 13, 2, 3),
(4, 'UNPAID', 12000000, 14, 9, 4),
(2, 'DONE', 6000000, 15, 5, 5),
(5, 'CANCEL', 15000000, 16, 8, 6),
(3, 'PAID', 9000000, 17, 15, 7),
(6, 'UNPAID', 18000000, 18, 18, 8),
(4, 'DONE', 12000000, 9, 9, 9),
(2, 'CANCEL', 6000000, 15, 3, 10),
(5, 'PAID', 15000000, 6, 16, 26),
(3, 'UNPAID', 9000000, 7, 17, 27),
(6, 'DONE', 18000000, 8, 18, 28),
(4, 'CANCEL', 12000000, 9, 1, 29),
(2, 'PAID', 6000000, 10, 5, 30),
(5, 'UNPAID', 15000000, 1, 11, 21),
(3, 'DONE', 9000000, 2, 12, 22),
(6, 'CANCEL', 18000000, 3, 13, 23),
(4, 'PAID', 12000000, 4, 14, 24),
(2, 'UNPAID', 6000000, 5, 15, 25),
(3, 'CANCEL', 9000000, 16, 8, 6),
(5, 'PAID', 15000000, 17, 5, 7),
(4, 'UNPAID', 12000000, 18, 8, 18),
(2, 'DONE', 6000000, 10, 11, 9),
(6, 'CANCEL', 18000000, 20, 3, 10),
(5, 'PAID', 15000000, 11, 13, 1),
(3, 'UNPAID', 9000000, 12, 4, 2),
(6, 'DONE', 18000000, 13, 7, 3),
(4, 'CANCEL', 12000000, 14, 9, 4),
(2, 'PAID', 6000000, 15, 6, 5),
(3, 'DONE', 9000000, 11, 6, 16),
(5, 'CANCEL', 15000000, 4, 7, 17),
(4, 'PAID', 12000000, 9, 8, 18),
(2, 'UNPAID', 6000000, 11, 9, 19),
(6, 'DONE', 18000000, 7, 10, 20),
(5, 'CANCEL', 15000000, 7, 1, 11),
(3, 'PAID', 9000000, 8, 2, 12),
(6, 'UNPAID', 18000000, 6, 3, 13),
(4, 'DONE', 12000000, 8, 4, 14),
(2, 'CANCEL', 6000000, 9, 5, 15);

update t_booking set created_at = current_date() where id > 0;

insert into t_customer_bookings(bookings_id,customer_id)
select id, customer_id from t_booking;

