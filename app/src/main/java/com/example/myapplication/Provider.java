/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.example.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class Provider extends ContentProvider {
  public Provider() {}

  @Override
  public int delete(Uri uri, String selection, String[] selectionArgs) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  @Override
  public String getType(Uri uri) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  @Override
  public Uri insert(Uri uri, ContentValues values) {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  @Override
  public boolean onCreate() {
    return false;
  }

  @Override
  public Cursor query(
      Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
    SQLiteDatabase db = new SQLHelper(this.getContext()).getWritableDatabase();
    if (selectionArgs != null) {
      db.execSQL("SELECT * FROM table WHERE key='" + selectionArgs[0] + "'");
    }

    return db.query("table", projection, selection, selectionArgs, null, null, sortOrder);
  }

  @Override
  public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
    throw new UnsupportedOperationException("Not yet implemented");
  }
}
