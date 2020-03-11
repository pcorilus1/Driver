package net.androidbootcamp.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;

import java.util.List;


public class Vendor_Items extends RecyclerView.Adapter<Vendor_Items.ViewHolder> {


    private Context context;
    private List<Order> orders;
    //private Boolean favorited = false;
    private final String LISTORDERS = "LISTORDERS";

    public Vendor_Items(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_post, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.bind(order);

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView5;
        // private ImageButton heart_btn;
        private Button button2;
        private TextView textView6;
        // private ImageView ivImage;
        //  private ImageButton btn_Comment;
        //   private TextView cnt_comment;
        //  private TextView cnt_like;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView5 = itemView.findViewById(R.id.textView5);
            button2 = itemView.findViewById(R.id.button2);
            textView6 = itemView.findViewById(R.id.textView6);
            // heart_btn = itemView.findViewById(R.id.heart_icon);
            // viewProducts_btn = itemView.findViewById(R.id.viewProducts_btn);

            button2.setOnClickListener(new View.OnClickListener() {

                //itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, Driver.class);
                    context.startActivity(intent);
                }

            });
        }


        //----------------------------------------------------------------------------------
        //  Put store on Recycler View
        //----------------------------------------------------------------------------------
        public void bind(Order order) {

            Log.d("LOG", "Status" + order.getCusId());

            order.getParseObject("cus_id").fetchIfNeededInBackground(new GetCallback<ParseObject>() {
                @Override
                public void done(ParseObject object, ParseException e) {
                    ParseObject customer = object;
                    textView5.setText(customer.getString("cus_first_name") + " " + customer.getString("cus_last_name"));
                }
            });
            Log.d("Order", "->" + order.getOrder());
            textView6.setText(order.getOrder().toString());
        }

        //tvCaption.setText(store.getCaption());
            /*ParseFile image = post.getImage();
            if(image != null){
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }*/
        //Log.d("COMMENT", "Comments: " + post.getCommentCount());


    }
}



/*public class Vendor_Items extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_items);

        listView=(ListView)findViewById(R.id.listView);


    }
}*/
