package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    // Test based on answer from StackOverflow found here:
    // https://stackoverflow.com/a/44222992
    @Test
    public void testGetJoke() throws InterruptedException {

        assertTrue(true);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Context context = InstrumentationRegistry.getContext();
        EndpointsAsyncTask testTask = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull("Result is null", result);
                assertTrue(result.length() > 0);
                countDownLatch.countDown();
            }
        };
        testTask.execute(context);
        countDownLatch.await();
    }
}