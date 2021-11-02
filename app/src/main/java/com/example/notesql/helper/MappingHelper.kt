package com.example.notesql.helper

import android.database.Cursor
import com.example.notesql.Note
import com.example.notesql.db.DatabaseContract

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?) : ArrayList<Note>{
        val noteList = ArrayList<Note>()

        notesCursor?.apply {
            while (moveToNext()){
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                noteList.add(Note(id, title, description, date))
            }
        }
        return noteList
    }
}