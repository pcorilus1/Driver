package net.androidbootcamp.myapplication;

import androidx.recyclerview.widget.RecyclerView;

import com.parse.GetCallback;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Order")
public class Order extends ParseObject {

        public static final String KEY_STATUS = "ord_status";
        public static final String KEY_UPDATE = "ord_last_update";
//public static final String KEY_PASSWORD = "password";
        public static final String KEY_TOTAL = "ord_total";
        public static final String KEY_LOCATION ="ord_driver_location_";
        public static final String KEY_STORE ="sto_id";
        public static final String KEY_ADD ="add_id";
        public static final String KEY_CUS ="cus_id";
        public static final String KEY_CC ="cc_id";
        public static final String KEY_ORDER ="ord_created";
//public static final String KEY_LOCATION = "location";

        public Order() {super();}

        public String getStatus(){ return getString(KEY_STATUS); }
        public void setStatus(String ord_status){ put(KEY_STATUS, ord_status); }

        public Number getUpdate(){ return getNumber(KEY_UPDATE); }
        public void setUpdate(String ord_last_update){ put(KEY_UPDATE, ord_last_update); }

        public String getTotal(){ return getString(KEY_TOTAL); }
        public void setTotal(String ord_total){ put(KEY_TOTAL, ord_total); }

        public Number getOrder(){ return getNumber(KEY_ORDER); }
        public void setOrder(Number ord_created){ put(KEY_ORDER, ord_created); }

        public String getLocation(){ return getString(KEY_LOCATION); }
        public void setLocation(String ord_driver_location_){ put(KEY_LOCATION, ord_driver_location_); }

        public ParseUser getStoId(){ return getParseUser(KEY_STORE); }
        public void setStoId(String sto_id){ put(KEY_STORE, sto_id); }

        public ParseUser getAddId(){ return getParseUser(KEY_ADD); }
        public void setAddId(String add_id){ put(KEY_ADD, add_id); }

        public ParseUser getCusId(){ return getParseUser(KEY_CUS); }
        public void setCusId(String cus_id){ put(KEY_CUS, cus_id); }

        public ParseUser getCCId(){ return getParseUser(KEY_CC); }
        public void setCCId(ParseUser cc_id){ put(KEY_CC, cc_id); }











            //sto_id  add_id  cus_id  cc_id  dri_id






        /*public
        ParseUser getUser(){
            return getParseUser(KEY_); }

        public
        void setUser(ParseUser
                             user){
            put(KEY_USERNAME, user); }



        public
        String getPhonenum(){
            return getString(KEY_PHONENUM); }

        public
        void setPhonenum(String
                                 phonenum){
            put(KEY_PHONENUM, phonenum); }



        public
        boolean getIsStylist(){
            return getBoolean(KEY_ISSTYLIST); }

        public
        void setIsStylist(boolean
                                  isStylist){
            put(KEY_ISSTYLIST, isStylist); }



        public
        ParseFile getImage() {

            return
                    getParseFile(KEY_IMAGE);

        }

        public
        void setImage(ParseFile
                              image){

            put(KEY_IMAGE, image);

        }*/




}




