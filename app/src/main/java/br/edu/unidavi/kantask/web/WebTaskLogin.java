package br.edu.unidavi.kantask.web;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.edu.unidavi.kantask.R;
import br.edu.unidavi.kantask.model.Usuario;

public class WebTaskLogin extends WebTaskBase{

    private static final String LOGIN = "login";
    private String userName;
    private String passWord;

    public WebTaskLogin(Context context, String user, String passWord){
        super(context, LOGIN);
        this.userName = user;
        this.passWord = passWord;
    }

    @Override
    public void handleResponse(String response) {
        Usuario user = new Usuario();
        try {
            JSONObject responseAsJSON = new JSONObject(response);

            user.setName(responseAsJSON.getString("name"));
            user.setToken(responseAsJSON.getString("token"));

            EventBus.getDefault().post(user);
        } catch (JSONException e) {
            EventBus.getDefault().post(new Error(getContext().getString(R.string.label_error_invalid_response)));
        }
    }

    @Override
    public String getRequestBody() {
        Map<String,String> requestMap = new HashMap<>();
        requestMap.put("username", userName);
        requestMap.put("password", passWord);

        JSONObject json = new JSONObject(requestMap);
        String jsonString = json.toString();

        return  jsonString;
    }

}
