package book.learning.my.sms_reader;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SMSListAdapter  extends BaseAdapter
{

    private Context mContext;
    Cursor cursor;
    public SMSListAdapter(Context context,Cursor cur)
    {
        super();
        mContext=context;
        cursor=cur;

    }

    public int getCount()
    {
        // return the number of records in cursor
        return cursor.getCount();
    }

    // getView method is called for each item of ListView
    public View getView(int position,  View view, ViewGroup parent)
    {
        // inflate the layout for each item of listView
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.listview_each_item, null);

        // move the cursor to required position
        cursor.moveToPosition(position);

        // fetch the sender number and sms body from cursor
        String senderNumber=cursor.getString(cursor.getColumnIndex("address"));
        String smsBody=cursor.getString(cursor.getColumnIndex("body"));

        // get the reference of textViews
        TextView textViewConatctNumber=(TextView)view.findViewById(R.id.textViewSMSSender);
        TextView textViewSMSBody=(TextView)view.findViewById(R.id.textViewMessageBody);

        // Set the Sender number and smsBody to respective TextViews
        textViewConatctNumber.setText(senderNumber);
        textViewSMSBody.setText(smsBody);


        return view;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
}
