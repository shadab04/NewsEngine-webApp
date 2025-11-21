📌 Overview

APNA NEWS is a feature-rich, production-style real-time news web platform designed to deliver live updates, smart category filtering, dark/light mode, authentication system, and an elegant user interface.
Built using Java Servlets and modern frontend technologies, the project follows clean architecture principles and replicates the experience of professional news portals (e.g., The Hindu, Indian Express, TOI).

<img width="1892" height="926" alt="image" src="https://github.com/user-attachments/assets/b41f6b5e-e26f-49a7-b456-554a67360905" />

This project demonstrates strong skills in:

✔ Full-stack development
✔ Clean architecture
✔ Responsive UI/UX
✔ API integration
✔ Java-based web application deployment

🏆 Key Features
🔥 Live News Fetching (API Based)

Fetches real-time breaking news using free public APIs with dynamic rendering of articles.

📌 Smart Category Filtering

Users can instantly filter news by:

India

World

Sports

Health

Business

Science

Premium

Opinion

Technology

And more...

🔍 Deep Search Integration

A fully dynamic search engine allows users to find any news topic instantly with API calls.

🌙 Dark / Light Theme Mode

Built-in theme toggle with localStorage persistence so user preference stays saved.

🔐 User Authentication

Registration page

Login page

Session-based authentication

Input validation

(Optional) MySQL + JDBC + BCrypt hashing

🎨 Premium UI/UX

Inspired by top Indian news websites

Card-based layout

Elegant typography

Standardized spacing

Fully responsive design

Mobile-friendly navigation

⚡ High Performance Rendering

DOM fragment optimization

Reusable <template> for rendering news cards

Minimal reflows & repaints

🛠️ Tech Stack
Frontend

HTML5

CSS3

Modern JavaScript (ES6+)

Backend

Java Servlets

JSP (optional)

Apache Tomcat 9 / WebLogic 12c

Database (Optional)

MySQL

JDBC

jBCrypt password hashing

APIs

News API (development)

Optional: Custom backend proxy for production

🧱 Architecture
<img width="1024" height="1536" alt="ChatGPT Image Nov 22, 2025, 01_11_53 AM" src="https://github.com/user-attachments/assets/92ed0a02-578e-4f88-a74b-b4ff14019d96" />

📂 Project Directory Structure

<img width="1024" height="1536" alt="ChatGPT Image Nov 22, 2025, 12_24_15 AM" src="https://github.com/user-attachments/assets/b19a9ede-91b6-4cba-a543-94632f2bac38" />


⚙️ Installation & Setup
1. Clone the Repository
git clone https://github.com/shadab04/NewsEngine-webApp.git

2. Import Project

Open Eclipse → File → Import → Dynamic Web Project

OR IntelliJ → File → New → Project from Existing Sources

3. Configure Server

Add Apache Tomcat / WebLogic Server

Deploy your project

Start the server

4. Navigate to Application
http://localhost:8081/NewsProject/

🔐 Authentication Workflow

1️⃣ User registers → Data validated → (Optional DB insert)
2️⃣ LoginServlet verifies credentials
3️⃣ Session is created and stored
4️⃣ Users get access to personalized sections
5️⃣ Session invalidation on logout

Supports:

Input validations

Secure password storage (BCrypt option)

HTTP-only cookies (optional)

🌟 Highlight Code Snippet
Dynamic News Fetching
async function fetchNews(query) {
  const res = await fetch(`${BASE_URL}${query}&apiKey=${API_KEY}`);
  const data = await res.json();
  bindData(data.articles);
}

Reusable Card Rendering
const template = document.getElementById("template-news-card");

articles.forEach(article => {
  const clone = template.content.cloneNode(true);
  fillCard(clone, article);
  cardsContainer.appendChild(clone);
});

Dark Mode Toggle
toggle.addEventListener("click", () => {
  document.body.classList.toggle("dark");
  localStorage.setItem("theme",
    document.body.classList.contains("dark") ? "dark" : "light"
  );
});

🚀 Future Enhancements

Personalized user dashboard

Save / Bookmark articles

AI-based trending news recommendations

Multi-language news

Subscription-based premium content

Native Android App version

🤝 Contributing

Contributions are welcome!
If you want to add features or fix bugs, just:

Fork the repo

Create your feature branch

Commit changes

Open PR

📬 Contact

Shadab Khan
🎓 Java Developer | Web Developer
📧 Email: shadabkhanasr04@gmail.com

🔗 GitHub: https://github.com/shadab04/NewsEngine-webApp

❤️ If you like this project, don't forget to star! ⭐
 

