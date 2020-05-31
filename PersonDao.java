package com.example.android19;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    void insert(Person person);

    @Query("Select * from person_table where priority=1 or priority=2 or priority=3")
    List<Person> getallpersons();

    @Query("Select * from person_table where priority=0")
    List<Person> getallpersonsnotest();

    @Query("Select max(waitingList) from person_table")
    int getmaxwaitinglist();


}
