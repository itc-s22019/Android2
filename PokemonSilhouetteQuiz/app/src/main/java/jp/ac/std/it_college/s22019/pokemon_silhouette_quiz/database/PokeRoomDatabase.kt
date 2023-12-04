package jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import jp.ac.std.it_college.s22019.pokemon_silhouette_quiz.database.entity.Poke

@Database(
    version = 1,
    entities = [
        Poke::class,
    ]
)
abstract class PokeRoomDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: PokeRoomDatabase? = null

        fun getDatabase(context: Context): PokeRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokeRoomDatabase::class.java,
                    "poke_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}