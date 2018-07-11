package com.fx.presenter;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fx.modle.Student;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by Administrator on 2018/7/9.
 */
@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    Single<List<Student>> getAll();
@Query("SELECT*FROM student WHERE id IN (:ids)")
    Single<List<Student>> loadAllByIds(int[] ids);
    @Query("SELECT*FROM student WHERE id =:id")
Single<Student> findbyid(int id);
    @Query("SELECT * FROM student WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    Maybe<Student> findByName(String first, String last);

    @Insert
    List<Long> insertAll(Student... students);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);
}
