🚗 Truth Vehicle Auction 🔨
Where Bidding Meets Transparency 💎
<p align="center"> <img src="https://img.freepik.com/free-vector/auction-concept-illustration_114360-16296.jpg" width="700"> <br> <em>🔧 A Real-Time Bidding Platform That Drives Fairness 🛣</em> </p>
📜 Project Description
Truth Vehicle Auction is a modern, real-time online auction system built for:

🧑‍💼 Admins managing vehicles and bids

👤 Users participating in live bidding

🚀 Organizations seeking transparent vehicle sales

🎯 Core Goals:

Ensure live, fair, and competitive bidding

Empower admins to monitor and manage auctions

Let users bid with confidence in a smooth, dynamic UI

📸 Screenshots
🏠 Home 
<p align="center"> <img src="https://github.com/Dinithilakshani/TruthAuction/blob/493b6caf2fca7e0a7953fd2178d990d4381c8727/Screenshot%202025-04-16%20231008.png" width="700" alt="Homepage"> <br> <em>User Homepage! 📈</em> </p>
🛠 Admin Auction Dashboard
<p align="center"> <img src="https://github.com/Dinithilakshani/TruthAuction/blob/1766738d7252e055ec4feaa7c155518cdd68fb06/Screenshot%202025-04-16%20230619.png" width="700" alt="Admin Dashboard"> <br> <em>Manage vehicles, monitor top bids and participant data 🧾</em> </p>
🧾 Bid Entry Form
<p align="center"> <img src="https://github.com/yourusername/Truth-Vehicle-Auction/blob/main/screenshots/bid-form.png" width="700" alt="Bid Form"> <br> <em>Submit your best bid—live updates in action! 💥</em> </p>
🛠 Setup Instructions
⚙ Backend (Spring Boot)
📁 Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/Truth-Vehicle-Auction.git
cd Truth-Vehicle-Auction/backend
🐘 Create database:

sql
Copy
Edit
CREATE DATABASE truth_auction;
🔧 Configure application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/truth_auction
spring.datasource.username=your_username
spring.datasource.password=your_password
🚀 Run the project:

bash
Copy
Edit
mvn spring-boot:run
🔍 Access Swagger UI:

http://localhost:8082/swagger-ui/index.html

💻 Frontend (HTML + Bootstrap + jQuery)
📂 Navigate to frontend folder:

bash
Copy
Edit
cd ../frontend
🧠 Open index.html in your browser directly
OR serve it via VS Code Live Server or a simple HTTP server.

✅ Ensure your backend (API) is running at:

bash
Copy
Edit
http://localhost:8082/api/v1/auction
🎥 Demo Video
Click to watch the walkthrough:

<p align="center"> ▶ <a href="https://youtu.be/truth-vehicle-auction-demo"> <img src="https://img.youtube.com/vi/demo-video-id/0.jpg" width="600" alt="Demo Video Thumbnail"> <br> <em>Truth_Vehicle_Auction_Demo_2025.mp4 🎬</em> </a> </p>
🌟 Core Features

Feature	Description
🔄 Live Bidding	See bids update instantly via AJAX
🧑‍💻 Admin Controls	View, edit, and delete vehicle auction data
🧾 Chassis Filtering	Filter vehicle list by chassis number
📈 Max Bid Sync	Pulls highest bid per user in real-time
📬 Email-linked Bidding	Track bids per user email
🚀 Optional: Docker Setup
For a more scalable setup

bash
Copy
Edit
docker-compose up --build -d
🧱 Includes:

MySQL with pre-loaded schema

Spring Boot backend

Static HTML frontend (optional to reverse-proxy via NGINX)

🙌 Contributors
Made with 🔥 and ☕ by:

👨‍💻 [Your Name] – Full Stack Developer

🧪 QA Team – Ensuring smooth performance

🤝 Beta Testers – Thank you for your insights!

📬 Let's Connect
💌 Email: truth.auctions@example.com
📱 Telegram: @truthvehicle_bot
📢 Discord: Join Our Server
