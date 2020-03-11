package net.androidbootcamp.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import static java.util.jar.Pack200.Packer.ERROR;

public class ListOrdersFragment extends Fragment {

    private RecyclerView rviewPosts;
   // protected final String FEED = "FEED";
  //  protected final String ERROR = "ERROR";
    protected Vendor_Items adapter;
    protected List<Order> mOrderPosts;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_vendor_items, container, false);

    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rviewPosts = view.findViewById(R.id.recyclerView);


        //create data source
        mOrderPosts = new ArrayList<>();
        //create adapter
        adapter = new Vendor_Items(getContext(), mOrderPosts);
        //set adapter on the recycler view
        rviewPosts.setAdapter(adapter);
        //set the layout manger on the recycler view
        rviewPosts.setLayoutManager(new LinearLayoutManager(getContext()));

        queryPosts();
    }

    protected void queryPosts() {

        ParseQuery<Order> storeQuery = new ParseQuery<Order>(Order.class);
        storeQuery.setLimit(20);
        //postQuery.addDescendingOrder(Post.KEY_CREATED_AT);
        storeQuery.findInBackground(new FindCallback<Order>() {
            @Override
            public void done(List<Order> orders, ParseException e) {
                if (e != null){
                    Log.e(ERROR, "Error with Query");
                    e.printStackTrace();
                    return;
                }
                mOrderPosts.addAll(orders);
                adapter.notifyDataSetChanged();
                /*
                for (int i=0; i<stores.size(); i++) {
                    Store store = stores.get(i);
                    //Log.d(POST, "Post: " + post.getCaption() + ", Username: " + post.getAuthor().getUsername());
                }
                */

            }
        });
    }


}
