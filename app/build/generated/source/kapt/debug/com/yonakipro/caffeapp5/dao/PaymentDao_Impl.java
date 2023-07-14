package com.yonakipro.caffeapp5.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.yonakipro.caffeapp5.payment.Payment;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PaymentDao_Impl implements PaymentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Payment> __insertionAdapterOfPayment;

  private final EntityDeletionOrUpdateAdapter<Payment> __deletionAdapterOfPayment;

  private final EntityDeletionOrUpdateAdapter<Payment> __updateAdapterOfPayment;

  public PaymentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPayment = new EntityInsertionAdapter<Payment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `payment12_table` (`id`,`address`,`nameOrder`,`order`,`charge`,`latitude`,`longitude`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Payment value) {
        stmt.bindLong(1, value.getId());
        if (value.getAddress() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAddress());
        }
        if (value.getNameOrder() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNameOrder());
        }
        if (value.getOrder() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOrder());
        }
        if (value.getCharge() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCharge());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getLatitude());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getLongitude());
        }
      }
    };
    this.__deletionAdapterOfPayment = new EntityDeletionOrUpdateAdapter<Payment>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `payment12_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Payment value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPayment = new EntityDeletionOrUpdateAdapter<Payment>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `payment12_table` SET `id` = ?,`address` = ?,`nameOrder` = ?,`order` = ?,`charge` = ?,`latitude` = ?,`longitude` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Payment value) {
        stmt.bindLong(1, value.getId());
        if (value.getAddress() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAddress());
        }
        if (value.getNameOrder() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNameOrder());
        }
        if (value.getOrder() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOrder());
        }
        if (value.getCharge() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCharge());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getLatitude());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getLongitude());
        }
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public Object insertPayment(final Payment payment,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPayment.insert(payment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deletePayment(final Payment payment,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPayment.handle(payment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public void updatePayment(final Payment payment) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPayment.handle(payment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flow<List<Payment>> getAllPayment() {
    final String _sql = "SELECT * FROM `payment12_table` ORDER BY `order` ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"payment12_table"}, new Callable<List<Payment>>() {
      @Override
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfNameOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "nameOrder");
          final int _cursorIndexOfOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "order");
          final int _cursorIndexOfCharge = CursorUtil.getColumnIndexOrThrow(_cursor, "charge");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Payment _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpNameOrder;
            if (_cursor.isNull(_cursorIndexOfNameOrder)) {
              _tmpNameOrder = null;
            } else {
              _tmpNameOrder = _cursor.getString(_cursorIndexOfNameOrder);
            }
            final String _tmpOrder;
            if (_cursor.isNull(_cursorIndexOfOrder)) {
              _tmpOrder = null;
            } else {
              _tmpOrder = _cursor.getString(_cursorIndexOfOrder);
            }
            final String _tmpCharge;
            if (_cursor.isNull(_cursorIndexOfCharge)) {
              _tmpCharge = null;
            } else {
              _tmpCharge = _cursor.getString(_cursorIndexOfCharge);
            }
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            _item = new Payment(_tmpId,_tmpAddress,_tmpNameOrder,_tmpOrder,_tmpCharge,_tmpLatitude,_tmpLongitude);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
