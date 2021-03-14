package com.disdukcapil.themoviedb_jetpack_submisi_1.utils


import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.MovieEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.TvShowEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.response.Movie
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.response.TvShow

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",                "en",
                "2021-03-03",
                4783.538,
                8.6,
                527774,
                "Raya and the Last Dragon",
                823,
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance.",
                "en",
                "2020-11-20",
                2379.091,
                5.7,
                590706,
                "Jiu Jitsu",
                123,
                "/eLT8Cu357VOwBVTitkmlDEg32Fs.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                "en",
                "2020-08-22",
                1387.921,
                7.4,
                577922,
                "Tenet",
                2729,
                "/k68nPLbIST6NP96JmTxmZijEvCA.jpg"
            )
        )
        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()
        tvShows.add(
            TvShowEntity(
                "2021-01-15",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",                "en",
                2425.602,
                8.5,
                "WandaVision",
                85271,
                7203,
                "/glKDfE6btIRcVB5zrjspRIs4r52.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                "en",
                909.814,
                8.6,
                "The Good Doctor",
                71712,
                5956,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )
        tvShows.add(
            TvShowEntity(
                "2005-03-27",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "en",
                871.161,
                8.1,
                "Grey's Anatomy",
                1416,
                4554,
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )
        return tvShows
    }

    fun generateRemoteDummyMovies(): List<Movie> {
        val movies = ArrayList<Movie>()
        movies.add(
            Movie(
                "Nory and her best friend Reina enter the Sage Academy for Magical Studies, where Nory’s unconventional powers land her in a class for those with wonky, or “upside-down,” magic. Undaunted, Nory sets out to prove that that upside-down magic can be just as powerful as right-side-up.",
                "en",
                "2020-07-31",
                2323.196,
                7.7,
                671583,
                "Upside-Down Magic",
                68,
                "/xfYMQNApIIh8KhpNVtG1XRz0ZAp.jpg"
            )
        )
        movies.add(
            Movie(
                "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance.",
                "en",
                "2020-11-20",
                2379.091,
                5.7,
                590706,
                "Jiu Jitsu",
                123,
                "/eLT8Cu357VOwBVTitkmlDEg32Fs.jpg"
            )
        )
        movies.add(
            Movie(
                "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                "en",
                "2020-08-22",
                1387.921,
                7.4,
                577922,
                "Tenet",
                2729,
                "/k68nPLbIST6NP96JmTxmZijEvCA.jpg"
            )
        )
        return movies
    }

    fun generateRemoteDummyTvShows(): List<TvShow> {
        val tvShows = ArrayList<TvShow>()
        tvShows.add(
            TvShow(
                "2019-11-12",
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                "en",
                1959.989,
                8.5,
                "The Mandalorian",
                82856,
                3607,
                "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg"
            )
        )
        tvShows.add(
            TvShow(
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                "en",
                909.814,
                8.6,
                "The Good Doctor",
                71712,
                5956,
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )
        tvShows.add(
            TvShow(
                "2005-03-27",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "en",
                871.161,
                8.1,
                "Grey's Anatomy",
                1416,
                4554,
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )
        return tvShows
    }

}