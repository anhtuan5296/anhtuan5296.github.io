-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2023 at 05:47 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopeemanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`, `description`, `image`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Electronics', 'Electronic devices and accessories', 'electronics.jpg', '2023-06-15', NULL, NULL),
(2, 'Clothing', 'Clothing and apparel', 'clothing.jpg', '2023-06-15', NULL, NULL),
(3, 'Books', 'Books and literature', 'books.jpg', '2023-06-15', NULL, NULL),
(4, 'Beauty', 'Beauty and skincare products', 'beauty.jpg', '2023-06-15', NULL, NULL),
(5, 'Home', 'Home decor and appliances', 'home.jpg', '2023-06-15', NULL, NULL),
(6, 'Sports', 'Sports equipment and gear', 'sports.jpg', '2023-06-15', NULL, NULL),
(7, 'Toys', 'Toys and games', 'toys.jpg', '2023-06-15', NULL, NULL),
(8, 'Jewelry', 'Jewelry and accessories', 'jewelry.jpg', '2023-06-15', NULL, NULL),
(9, 'Automotive', 'Automotive parts and accessories', 'automotive.jpg', '2023-06-15', NULL, NULL),
(10, 'Furniture', 'Furniture and home furnishings', 'furniture.jpg', '2023-06-15', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `coupons`
--

CREATE TABLE `coupons` (
  `id` int(11) NOT NULL,
  `couponCode` varchar(20) NOT NULL,
  `discount` float DEFAULT NULL,
  `expirationDate` date DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coupons`
--

INSERT INTO `coupons` (`id`, `couponCode`, `discount`, `expirationDate`, `created_at`, `updated_at`, `deleted_at`, `status`) VALUES
(1, 'SUMMER10', 0.1, '2023-09-30', '2023-06-15', NULL, NULL, 'active'),
(2, 'SALE20', 0.2, '2023-07-31', '2023-06-15', NULL, NULL, 'active'),
(3, 'FREESHIP', 1, '2023-12-31', '2023-06-15', NULL, NULL, 'active'),
(4, 'HOLIDAY25', 0.25, '2023-12-25', '2023-06-15', NULL, NULL, 'active'),
(5, 'FIRSTTIME15', 0.15, '2023-08-31', '2023-06-15', NULL, NULL, 'active'),
(6, 'SPECIAL30', 0.3, '2023-09-15', '2023-06-15', NULL, NULL, 'active'),
(7, 'MEMBER10', 0.1, '2023-12-31', '2023-06-15', NULL, NULL, 'active'),
(8, 'FLASHSALE50', 0.5, '2023-06-20', '2023-06-15', NULL, NULL, 'active'),
(9, 'WEEKEND20', 0.2, '2023-06-18', '2023-06-15', NULL, NULL, 'active'),
(10, 'BIRTHDAY5', 0.05, '2023-12-31', '2023-06-15', NULL, NULL, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`id`, `product_id`, `quantity`, `note`, `created_at`, `updated_at`, `deleted_at`, `status`) VALUES
(1, 3, 5, 'hang de vo', '2023-06-15', NULL, NULL, 'active'),
(2, 5, 6, 'hang de vo', '2023-06-15', NULL, NULL, 'active'),
(3, 7, 1, 'hang de vo', '2023-06-15', NULL, NULL, 'active'),
(4, 2, 8, 'hang de vo', '2023-06-15', NULL, NULL, 'active'),
(5, 4, 22, 'hang de vo', '2023-06-15', NULL, NULL, 'active'),
(6, 6, 3, 'hang de vo', '2023-06-15', NULL, NULL, 'active'),
(7, 8, 4, 'hang de vo', '2023-06-15', NULL, NULL, 'active'),
(8, 10, 5, 'hang de vo', '2023-06-15', NULL, NULL, 'active'),
(9, 1, 5, 'hang de vo', '2023-06-15', NULL, NULL, 'active'),
(10, 9, 51, 'hang de vo', '2023-06-15', NULL, NULL, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `orderdetails_id` int(11) NOT NULL,
  `orderDate` date DEFAULT curdate(),
  `totalPrice` float DEFAULT NULL,
  `shippingAddress` varchar(255) NOT NULL,
  `shippingCity` varchar(50) NOT NULL,
  `shippingCountry` varchar(50) NOT NULL,
  `shippingPostalCode` varchar(10) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `orderdetails_id`, `orderDate`, `totalPrice`, `shippingAddress`, `shippingCity`, `shippingCountry`, `shippingPostalCode`, `phone`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 1, '2023-06-15', 129.99, '123 Main St', 'New York', 'USA', '12345', '1234567890', 'pending', '2023-06-15', NULL, NULL),
(2, 2, 2, '2023-06-15', 49.99, '456 Elm St', 'Los Angeles', 'USA', '67890', '9876543210', 'shipped', '2023-06-15', NULL, NULL),
(3, 3, 3, '2023-06-15', 79.99, '789 Oak St', 'Chicago', 'USA', '54321', '5555555555', 'delivered', '2023-06-15', NULL, NULL),
(4, 4, 4, '2023-06-15', 19.99, '987 Pine St', 'San Francisco', 'USA', '98765', '1111111111', 'canceled', '2023-06-15', NULL, NULL),
(5, 5, 5, '2023-06-15', 299.99, '654 Maple St', 'Seattle', 'USA', '56789', '9999999999', 'pending', '2023-06-15', NULL, NULL),
(6, 6, 6, '2023-06-15', 39.99, '321 Cedar St', 'Boston', 'USA', '34567', '2222222222', 'shipped', '2023-06-15', NULL, NULL),
(7, 7, 7, '2023-06-15', 149.99, '543 Birch St', 'Miami', 'USA', '87654', '8888888888', 'delivered', '2023-06-15', NULL, NULL),
(8, 8, 8, '2023-06-15', 69.99, '789 Pine St', 'Dallas', 'USA', '23456', '4444444444', 'pending', '2023-06-15', NULL, NULL),
(9, 9, 9, '2023-06-15', 89.99, '321 Oak St', 'Houston', 'USA', '76543', '6666666666', 'pending', '2023-06-15', NULL, NULL),
(10, 10, 10, '2023-06-15', 199.99, '654 Elm St', 'Phoenix', 'USA', '12345', '3333333333', 'shipped', '2023-06-15', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `paymentDate` date DEFAULT curdate(),
  `amount` float DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`id`, `order_id`, `paymentDate`, `amount`, `created_at`, `updated_at`, `deleted_at`, `status`) VALUES
(1, 1, '2023-06-15', 89.99, '2023-06-15', NULL, NULL, 'completed'),
(2, 2, '2023-06-15', 129.99, '2023-06-15', NULL, NULL, 'completed'),
(3, 3, '2023-06-15', 99.99, '2023-06-15', NULL, NULL, 'completed'),
(4, 4, '2023-06-15', 69.99, '2023-06-15', NULL, NULL, 'completed'),
(5, 5, '2023-06-15', 59.99, '2023-06-15', NULL, NULL, 'completed'),
(6, 6, '2023-06-15', 199.99, '2023-06-15', NULL, NULL, 'completed'),
(7, 7, '2023-06-15', 149.99, '2023-06-15', NULL, NULL, 'completed'),
(8, 8, '2023-06-15', 79.99, '2023-06-15', NULL, NULL, 'completed'),
(9, 9, '2023-06-15', 49.99, '2023-06-15', NULL, NULL, 'completed'),
(10, 10, '2023-06-15', 39.99, '2023-06-15', NULL, NULL, 'completed');

-- --------------------------------------------------------

--
-- Table structure for table `productcoupons`
--

CREATE TABLE `productcoupons` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `coupon_id` int(11) NOT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `productcoupons`
--

INSERT INTO `productcoupons` (`id`, `product_id`, `coupon_id`, `created_at`, `updated_at`, `deleted_at`, `status`) VALUES
(1, 1, 1, '2023-06-15', NULL, NULL, 'active'),
(2, 2, 2, '2023-06-15', NULL, NULL, 'active'),
(3, 3, 3, '2023-06-15', NULL, NULL, 'active'),
(4, 4, 4, '2023-06-15', NULL, NULL, 'active'),
(5, 5, 5, '2023-06-15', NULL, NULL, 'active'),
(6, 6, 6, '2023-06-15', NULL, NULL, 'active'),
(7, 7, 7, '2023-06-15', NULL, NULL, 'active'),
(8, 8, 8, '2023-06-15', NULL, NULL, 'active'),
(9, 9, 9, '2023-06-15', NULL, NULL, 'active'),
(10, 10, 10, '2023-06-15', NULL, NULL, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `stock` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `price`, `stock`, `category_id`, `seller_id`, `image`, `created_at`, `updated_at`, `deleted_at`, `status`) VALUES
(1, 'iPhone 12 Pro', 'Apple iPhone 12 Pro - 128GB', 1199.99, 10, 1, 1, 'iphone12pro.jpg', '2023-06-15', NULL, NULL, 'active'),
(2, 'Samsung Galaxy Note 20', 'Samsung Galaxy Note 20 - 256GB', 1099.99, 5, 1, 2, 'note20.jpg', '2023-06-15', NULL, NULL, 'active'),
(3, 'Men Hoodie', 'Casual hoodie for men', 39.99, 20, 2, 3, 'hoodie.jpg', '2023-06-15', NULL, NULL, 'active'),
(4, 'Women Shoes', 'Stylish sneakers for women', 79.99, 15, 2, 4, 'shoes.jpg', '2023-06-15', NULL, NULL, 'active'),
(5, 'Home Decorative Pillow', 'Soft and cozy decorative pillow', 19.99, 8, 3, 5, 'pillow.jpg', '2023-06-15', NULL, NULL, 'active'),
(6, 'Cooking Utensil Set', 'Set of essential cooking utensils', 29.99, 12, 4, 6, 'utensils.jpg', '2023-06-15', NULL, NULL, 'active'),
(7, 'Earrings', 'Stylish earrings for any occasion', 24.99, 10, 5, 7, 'earrings.jpg', '2023-06-15', NULL, NULL, 'active'),
(8, 'Yoga Blocks', 'Supportive yoga blocks for practice', 14.99, 15, 6, 8, 'yogablocks.jpg', '2023-06-15', NULL, NULL, 'active'),
(9, 'LEGO Star Wars Set', 'Star Wars-themed LEGO set', 99.99, 7, 7, 9, 'legostarwars.jpg', '2023-06-15', NULL, NULL, 'active'),
(10, 'Blender', 'Powerful blender for smoothies', 49.99, 10, 8, 10, 'blender.jpg', '2023-06-15', NULL, NULL, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`id`, `product_id`, `user_id`, `rating`, `image`, `comment`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 1, 4, NULL, 'Great phone, excellent camera quality.', '2023-06-15', NULL, NULL),
(2, 2, 2, 5, NULL, 'Fast and powerful device, highly recommended.', '2023-06-15', NULL, NULL),
(3, 3, 3, 4, NULL, 'Comfortable hoodie, perfect for colder weather.', '2023-06-15', NULL, NULL),
(4, 4, 4, 5, NULL, 'Beautiful shoes, very comfortable to wear.', '2023-06-15', NULL, NULL),
(5, 5, 5, 4, NULL, 'Lovely decorative pillow, adds a nice touch to my home.', '2023-06-15', NULL, NULL),
(6, 6, 6, 3, NULL, 'Decent quality cooking utensils, could be better.', '2023-06-15', NULL, NULL),
(7, 7, 7, 5, NULL, 'Gorgeous earrings, I receive compliments every time I wear them.', '2023-06-15', NULL, NULL),
(8, 8, 8, 4, NULL, 'Good quality yoga blocks, help with my yoga practice.', '2023-06-15', NULL, NULL),
(9, 9, 9, 5, NULL, 'Impressive LEGO set, hours of fun for my kids.', '2023-06-15', NULL, NULL),
(10, 10, 10, 4, NULL, 'Powerful blender, great for making smoothies.', '2023-06-15', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `usercoupons`
--

CREATE TABLE `usercoupons` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `coupon_id` int(11) NOT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usercoupons`
--

INSERT INTO `usercoupons` (`id`, `user_id`, `coupon_id`, `created_at`, `updated_at`, `deleted_at`, `status`) VALUES
(1, 1, 1, '2023-06-15', NULL, NULL, 'active'),
(2, 2, 2, '2023-06-15', NULL, NULL, 'active'),
(3, 3, 3, '2023-06-15', NULL, NULL, 'active'),
(4, 4, 4, '2023-06-15', NULL, NULL, 'active'),
(5, 5, 5, '2023-06-15', NULL, NULL, 'active'),
(6, 6, 6, '2023-06-15', NULL, NULL, 'active'),
(7, 7, 7, '2023-06-15', NULL, NULL, 'active'),
(8, 8, 8, '2023-06-15', NULL, NULL, 'active'),
(9, 9, 9, '2023-06-15', NULL, NULL, 'active'),
(10, 10, 10, '2023-06-15', NULL, NULL, 'active');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `postalCode` varchar(10) DEFAULT NULL,
  `created_at` date DEFAULT curdate(),
  `updated_at` date DEFAULT NULL,
  `deleted_at` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstName`, `lastName`, `email`, `password`, `phone`, `address`, `city`, `country`, `postalCode`, `created_at`, `updated_at`, `deleted_at`, `status`) VALUES
(1, 'John', 'Doe', 'johndoe@example.com', 'password123', '123456789', '123 Main Street', 'New York', 'USA', '12345', '2023-06-15', NULL, NULL, 'active'),
(2, 'Jane', 'Smith', 'janesmith@example.com', 'password456', '987654321', '456 Oak Avenue', 'Los Angeles', 'USA', '56789', '2023-06-15', NULL, NULL, 'active'),
(3, 'Alice', 'Johnson', 'alicejohnson@example.com', 'password789', '456123789', '789 Elm Street', 'Chicago', 'USA', '34567', '2023-06-15', NULL, NULL, 'active'),
(4, 'David', 'Brown', 'davidbrown@example.com', 'passwordabc', '789123456', '321 Pine Avenue', 'San Francisco', 'USA', '56789', '2023-06-15', NULL, NULL, 'active'),
(5, 'Sarah', 'Wilson', 'sarahwilson@example.com', 'passworddef', '456789123', '987 Maple Avenue', 'Boston', 'USA', '78901', '2023-06-15', NULL, NULL, 'active'),
(6, 'Michael', 'Taylor', 'michaeltaylor@example.com', 'passwordxyz', '123789456', '654 Cedar Street', 'Seattle', 'USA', '90123', '2023-06-15', NULL, NULL, 'active'),
(7, 'Emily', 'Anderson', 'emilyanderson@example.com', 'password456', '789123456', '147 Oak Street', 'Miami', 'USA', '23456', '2023-06-15', NULL, NULL, 'active'),
(8, 'Daniel', 'Clark', 'danielclark@example.com', 'password789', '456789123', '258 Pine Street', 'Houston', 'USA', '67890', '2023-06-15', NULL, NULL, 'active'),
(9, 'Olivia', 'White', 'oliviawhite@example.com', 'passwordabc', '123456789', '369 Elm Street', 'Dallas', 'USA', '01234', '2023-06-15', NULL, NULL, 'active'),
(10, 'Sophia', 'Thomas', 'sophiathomas@example.com', 'passworddef', '987654321', '741 Oak Avenue', 'Phoenix', 'USA', '56789', '2023-06-15', NULL, NULL, 'active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `coupons`
--
ALTER TABLE `coupons`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_orderDetails_products` (`product_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_order_user` (`user_id`),
  ADD KEY `fk_order_orderdetail` (`orderdetails_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_payment_order` (`order_id`);

--
-- Indexes for table `productcoupons`
--
ALTER TABLE `productcoupons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_productcoupon_product` (`product_id`),
  ADD KEY `fk_productcoupon_coupon` (`coupon_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_product_category` (`category_id`),
  ADD KEY `fk_product_user` (`seller_id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_revieww_product` (`product_id`),
  ADD KEY `fk_review_user` (`user_id`);

--
-- Indexes for table `usercoupons`
--
ALTER TABLE `usercoupons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usercoupon_user` (`user_id`),
  ADD KEY `fk_usercoupon_coupon` (`coupon_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `coupons`
--
ALTER TABLE `coupons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `productcoupons`
--
ALTER TABLE `productcoupons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `usercoupons`
--
ALTER TABLE `usercoupons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `fk_orderDetails_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_order_orderdetail` FOREIGN KEY (`orderdetails_id`) REFERENCES `orderdetails` (`id`),
  ADD CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `fk_payment_order` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Constraints for table `productcoupons`
--
ALTER TABLE `productcoupons`
  ADD CONSTRAINT `fk_productcoupon_coupon` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`id`),
  ADD CONSTRAINT `fk_productcoupon_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `fk_product_user` FOREIGN KEY (`seller_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `fk_review_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `fk_revieww_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `usercoupons`
--
ALTER TABLE `usercoupons`
  ADD CONSTRAINT `fk_usercoupon_coupon` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`id`),
  ADD CONSTRAINT `fk_usercoupon_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
