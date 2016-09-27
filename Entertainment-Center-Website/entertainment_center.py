import media
import fresh_tomatoes

the_dark_knight = media.Movie("The Dark Knight", "Batman returns to fight a new threat",
                              "https://upload.wikimedia.org/wikipedia/en/8/8a/Dark_Knight.jpg",
                              "https://www.youtube.com/watch?v=EXeTwQWrcwY")
star_wars_vii = media.Movie("Star Wars: The Force Awakens", "30 years later, two young heroes fight against the evil Kylo Ren",
                            "https://upload.wikimedia.org/wikipedia/en/a/a2/Star_Wars_The_Force_Awakens_Theatrical_Poster.jpg", 
                            "https://www.youtube.com/watch?v=sGbxmsDFVnE")
civil_war = media.Movie("Captain America: Civil War", "A new law forces the Avengers to split",
                        "https://upload.wikimedia.org/wikipedia/en/5/53/Captain_America_Civil_War_poster.jpg",
                        "https://www.youtube.com/watch?v=dKrVegVI0Us")
john_wick = media.Movie("John Wick", "A retired hitman seeks revenge on those who wronged him",
                        "https://upload.wikimedia.org/wikipedia/en/9/98/John_Wick_TeaserPoster.jpg",
                        "https://www.youtube.com/watch?v=2AUmvWm5ZDQ")
doctor_strange = media.Movie("Doctor Strange", "After a car accident, a surgoen discovers the mystic arts",
                             "https://upload.wikimedia.org/wikipedia/en/c/c7/Doctor_Strange_poster.jpg",
                             "https://www.youtube.com/watch?v=HSzx-zryEgM")
spiderman = media.Movie("Spider-Man", "A teenage boy gains superpowers after being bitten by a radioactive spider",
                        "https://upload.wikimedia.org/wikipedia/en/f/f3/Spider-Man2002Poster.jpg",
                        "https://www.youtube.com/watch?v=0KW8stZ2jSQ")
wonder_woman = media.Movie("Wonder Woman", "An Amazonian princess leaves her home to fight a war",
                           "https://upload.wikimedia.org/wikipedia/en/e/ed/Wonder_Woman_%282017_film%29.jpg",
                           "https://www.youtube.com/watch?v=5lGoQhFb4NM")
deadpool = media.Movie("Deadpool", "An unordinary superhero tries to find the man who scarred him",
                       "https://upload.wikimedia.org/wikipedia/en/4/46/Deadpool_poster.jpg",
                       "https://www.youtube.com/watch?v=ONHBaC-pfsk")
suicide_squad = media.Movie("Suicide Squad", "A team of supervillians fight a supernatural force",
                            "https://upload.wikimedia.org/wikipedia/en/5/50/Suicide_Squad_%28film%29_Poster.png",
                            "https://www.youtube.com/watch?v=CmRih_VtVAs")
movies = [the_dark_knight, star_wars_vii, civil_war, john_wick, doctor_strange, spiderman, wonder_woman, deadpool, suicide_squad]
fresh_tomatoes.open_movies_page(movies)
