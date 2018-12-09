package com.pokemon.spritedex.model.pojo.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.pokemon.spritedex.R;
import com.pokemon.spritedex.model.pojo.Pokemon;
import com.pokemon.spritedex.ui.activities.SpriteDexActivity;
import com.pokemon.spritedex.ui.adapters.SpriteDexAdapter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by brunocunha on 5/29/18.
 */

public class Download {

    public static final int STORAGE_PERMISSION_REQUEST = 1;

    public static boolean checkPermissions(Context context){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((SpriteDexActivity) context,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    STORAGE_PERMISSION_REQUEST);
            return false;
        } else {
            return true;
        }
    }

    public static void checkPermissionsAndDoDownload(Context context, Pokemon pokemon) {
        if (checkPermissions(context)) {
            doDownload(context, pokemon);
        }
    }

    public static void doDownload(Context context, Pokemon pokemon) {

        if (pokemon != null) {
            if (pokemon.getSprites() != null) {
                if (pokemon.getSprites().getFrontDefault() != null) {
                    try {
                        String url = pokemon.getSprites().getFrontDefault();
                        Picasso.get().load(url).into(getTarget(getFileName(pokemon.getName() + "_frontal_default.png")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (pokemon.getSprites().getBackDefault() != null) {
                    try {
                        String url = pokemon.getSprites().getBackDefault();
                        Picasso.get().load(url).into(getTarget(getFileName(pokemon.getName() + "_back_default.png")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (pokemon.getSprites().getFrontFemale() != null) {
                    try {
                        String url = pokemon.getSprites().getFrontFemale();
                        Picasso.get().load(url).into(getTarget(getFileName(pokemon.getName() + "_frontal_female.png")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (pokemon.getSprites().getBackFemale() != null) {
                    try {
                        String url = pokemon.getSprites().getBackFemale();
                        Picasso.get().load(url).into(getTarget(getFileName(pokemon.getName() + "_back_female.png")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (pokemon.getSprites().getFrontShiny() != null) {
                    try {
                        String url = pokemon.getSprites().getFrontShiny();
                        Picasso.get().load(url).into(getTarget(getFileName(pokemon.getName() + "_frontal_shiny.png")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (pokemon.getSprites().getBackShiny() != null) {
                    try {
                        String url = pokemon.getSprites().getBackShiny();
                        Picasso.get().load(url).into(getTarget(getFileName(pokemon.getName() + "_back_shiny.png")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (pokemon.getSprites().getFrontShinyFemale() != null) {
                    try {
                        String url = pokemon.getSprites().getFrontShinyFemale();
                        Picasso.get().load(url).into(getTarget(getFileName(pokemon.getName() + "_front_shiny_female.png")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (pokemon.getSprites().getBackShinyFemale() != null) {
                    try {
                        String url = pokemon.getSprites().getBackShinyFemale();
                        Picasso.get().load(url).into(getTarget(getFileName(pokemon.getName() + "_back_shiny_female.png")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                Toast.makeText(context, String.format(context.getString(R.string.msg_sucesso),
                        SpriteDexAdapter.setFirstLeterUpperCase(pokemon.getName()),
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath()), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, String.format(context.getString(R.string.msg_erro), pokemon.getName()), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(context, String.format(context.getString(R.string.msg_erro_load), pokemon.getName()), Toast.LENGTH_LONG).show();
        }
    }

    public static String getFileName(String fileName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/" + fileName);
        return uriSting;
    }

    private static Target getTarget(final String fileName) {
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            File file = new File(fileName);
                            if (file.exists()) {
                                file.delete();
                            }
                            file.createNewFile();
                            FileOutputStream fileoutputstream = new FileOutputStream(file);
                            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream);
                            fileoutputstream.write(bytearrayoutputstream.toByteArray());
                            fileoutputstream.close();
                        } catch (IOException e) {
                            Log.e("IOException", e.getLocalizedMessage());
                            Crashlytics.logException(e);
                        }
                    }
                }).start();

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        return target;
    }
}
