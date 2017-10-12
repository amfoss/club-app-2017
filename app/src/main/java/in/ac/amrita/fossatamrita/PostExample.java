package in.ac.amrita.fossatamrita;

import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostExample {
    private static final MediaType JSON
            = MediaType.parse("application/json;");

    private OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    String bowlingJson(String user, String password) {
        String str =  "{" +
                "\"username\": \"" + user + "\", " +
                "\"password\": \"" + password + "\"" +
                "}";
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) throws IOException {
        PostExample example = new PostExample();
        String json = example.bowlingJson(args[0], args[1]);
        String response = example.post("http://192.168.43.123:8000/api/jwt-auth/", json);
        System.out.println(args[0] + " " + args[1]);
        System.out.println(response);
    }
}