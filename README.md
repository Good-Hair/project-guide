# project-guide
README 
===


## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview
### Description
This app creates a hair sylist profile, allows users to browse and search for their desired style/stylist based on skill, location, etc. User can book with a stylist inside the app, and favorite sylists and styles.

### App Evaluation
- **Category:** Special Interest / Beauty
- **Mobile:** This app would be primarily developed for mobile but would perhaps be just as viable on a computer, such as tinder or other similar apps. Functionality wouldn't be limited to mobile devices, however mobile version has more features.
- **Story:** This app allows hair stylists to create a profile of their work and their services, and allows users to browse for a desired style or stylist based on a variety of filters such as location, skill, and more. This will aid in connecting hair stylists to clients and clients to good hair stylists.
- **Market:** Any individual could choose to use this app, primarily women will be drawn to this app, but we will have an option for men to browse for barbers as well.
- **Habit:** This app could be used as often or unoften as the user wanted depending on how often they get their hair done and user can casually browse through styles any time without booking.
- **Scope:** First we would start with being an easy way for people to find reliable hair stylists and being a platform for hair stylists and barbers to reach more clients, this could perhaps evolve into doing beauty accounts as well (for MUA's). 
## Product Spec
### 1. User Stories (Required and Optional)

**Required Must-have Stories**
  
  Stylist 
* Stylist Create Account- { First and Last name, username, password, Shop name, Bio, Location, types of styles they do- for each style minimum ten photos and videos, contact info(phone number, email, EIN, billing address), licenses}
* Stylist logs into account
* Stylist provides booking information/ availability
* Stylist can give promotion preference to appear on explore page
* Stylist can post and view photos of their work on profile
* Stylist recieves notifications when they are followed or booked
* Stylist can see list of followers

  User
* User creates account { First and Last name, username, password, selection of preferred styles, location, contact }
* User logs in to account
* Frst time user is asked to select their preffered styles from randomly chosen photos
* User is directed immediately to HomePage/Feed can scroll through and view (Like Instagram feed)
* User can go to Search and Explore page (Like Instgram) to search for specific styles or find something new
* User can favorite a style or follow a stylist or hashtag
* When user selects a stylist username they get redirected to stylist profile
* With clicking a photo a stylist posts of their their username below image will link to their page
* Every photo of a style/ hashtag will link to stylists who have the style name in their bio and you can filter based on location, photos, stylists and reviews(Like Instgram)on the search page
* Profile page for each user- user can view saved stylists and styles, and unsave/unfollow
* Settings (Accesibility, Notification, General, etc.) user can access in right hand corner of profile 
* Reviews- User can access phone camera to take a photo of hair and leave a written and rated review on stylist page


**Optional Nice-to-have Stories**
* In app Booking 
* CHAT with stylist
* Stylist user profile ( stlyist account acts as user account as well, stylist can follow other stylists, explore, and like other styles
* Photo tags with style price, additional stylist notes, and more from stylist attached to posted photo appearing on feed/ explore
* Click on general photo to view more detailed version of post 
### 2. Screen Archetypes

* Login - user can login
* Register - User signs up with new account or logs into their account
* Upon Download/Reopening of the application, the user is prompted to log in to gain access to their profile information to refresh feed.
* Feed - compiled photos of suggested styles and stylists based on previously favorited styles, followed stylists and hashtags
* Explore - Search bar at the top, can filter search results by Photo, Stylist, Location, Cost, etc. Below the search bar you can see explore page with photos of randomly posted/ promoted styles and you can like and view styles there
* Stylist Page- When a user clicks on a stylist username, they can view stylist profile, the styles they do, can write or view reviews, and can see style costs and book.
* User Profile- When a user selects their profile tab they can see all of their favorited styles, and the stylists and hashtags they follow. They can unfavorite or unfollow here as well.
* "Add Style" Screen  (Stylist)- Stylist can add a style 
* Settings Screen- Lets people change language, and app notification settings.

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Feed
* Explore
* Profile

**Flow Navigation** (Screen to Screen)
Login Screen
=> Feed

User Registration Screen
=> Feed

User Feed
=> Stylist profile or
=> Detailed view of stylist's post

User Explore
=> Stylist profile or
=> Detailed view of stylist post

User Profile
=> Stylist profile
=> Detailed view of stylist post

Login Screen 
=> Stylist Profile Page

## Wireframes
<img src="https://imgur.com/qA4z8Mg.jpg" width=800><br>
<img src="https://imgur.com/VEfv1nG.jpg" width=800><br>
<img src="https://imgur.com/YCyW3cQ.jpg" width=800><br>

## Network Request Outline
Login Page
*	(Read/GET) Query all user accounts
*	(Read/GET) Query all stylist accounts
*	(Create/POST) Create a new account object

User Account Registration
*	(Create/POST) Create a new user account object

User profile build (interests)
*	(Create/POST) Create a new user interests object

User Feed
*	(Read/GET) Query all posts that interest user
*	(Read/GET) Query all posts that user searches for
*	(Create/POST) Create a new like on a post
*	(Create/POST) Create a new comment on a post
*	(Delete) Delete existing like
*	(Delete) Delete existing comment

Stylist Account Registration
*	(Create/POST) Create a new stylist account object
*	(Create/POST) Create a new stylist profile object

Stylist profile (user perspective)
*	(Read/GET) Query all accounts for the selected stylist
*	(Create/POST) Create a new review object

Stylist profile (stylist perspective)
*	(Create/POST) Create a new post object
*	(Update/PUT) Update stylist profile image
*	(Update/PUT) Update stylist name
*	(Update/PUT) Update stylist profile image
*	(Delete) Delete existing post

User profile
*	(Create/POST) Create a new user profile object

User explorer page
*	(Read/GET) Query all posts that interest user
*	(Read/GET) Query all posts that user searches for

