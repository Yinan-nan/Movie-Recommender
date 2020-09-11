# Movie Recommender
Movie Recommender is a spring boot web application which allows users to submit movie ratings and get movie recommendations from people who have similar tastes.

You could find the application here: https://java-movie-recommendation.herokuapp.com

### Framwork and Database

  - Spring Boot : An open source Java-based framework used to create a micro Service.
  - PostgresQL : A free and open-source relational database management system emphasizing extensibility and SQL compliance

### DataSet
- Download dataset from **MovieLens** : It contains 27,000,000 ratings applied to 58,000 movies by 280,000 users.
- Scrap imdb_id, imdb_url, and poster_url for movies from IMDb website.
- Preprocess the dataset.


### Processing the dataset 

**Normalization:**
Raters have different rating habits. Some raters tend to give high rating scores while some raters tend to give lower rating scores. Some raters tend to give wide range of scores while some raters tend to give socres in narrow range.  Z-scores normalization effectively solves this problem.

Z-scores Normalization : It is calculated by subtracting the rating mean and then dividing the difference by the rating standard deviation. 
- ![equation](http://www.sciweavers.org/tex2img.php?eq=z%3D%20%5Cfrac%7Bx-%5Cmu%7D%7B%5Csigma%7D%20&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0)

where : 
- ![equation](https://bit.ly/2Buw8nb) is the mean of the ratings
- ![equation](https://bit.ly/2FGLngR) is the standard deviation of the ratings


**Select Popular Movies:**
Extract popular movies from the dataset with more than 5000 ratings and show them to users to rate, increasing the number of movies a user has ever watched before.

### Recommendation Algorithm
**Collaborative Filtering** : A technique that can filter out items that a user might like on the basis of reactions by similar users. It works by searching a large group of people and finding a smaller set of users with tastes similar to a particular user.

- Find the raters who have the most similarities with the user.
- From the movies rated by the raters found above, find top scored movies.

### Other Tools
- **Heroku** : Heroku is a cloud platform as a service supporting several programming languages. 
- **AWS RDS** : Amazon Relational Database Service is a distributed relational database service by Amazon Web Services.
- **Bootstrap** : Bootstrap is a free and open-source CSS framework directed at responsive, mobile-first front-end web development.
- **Thymeleaf** : Thymeleaf is a modern server-side Java template engine for both web and standalone environments. 



