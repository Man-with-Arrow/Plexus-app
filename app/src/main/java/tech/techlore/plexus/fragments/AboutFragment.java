package tech.techlore.plexus.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import tech.techlore.plexus.R;

public class AboutFragment extends Fragment {

    String version;

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // VERSION
        try {
            version = getResources().getString(R.string.version)
                    + " "
                    + requireContext().getPackageManager()
                    .getPackageInfo(requireContext()
                            .getPackageName(), 0)
                    .versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        ((TextView)view.findViewById(R.id.version)).setText(version);

        // PRIVACY POLICY
        view.findViewById(R.id.privacy_policy)
                .setOnClickListener(v -> {
                    try
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/techlore/Plexus-app/blob/main/PRIVACY.md")));
                    }
                    // IF BROWSERS NOT INSTALLED, SHOW TOAST
                    catch (ActivityNotFoundException e)
                    {
                        Toast.makeText(requireContext(), getString(R.string.no_browsers), Toast.LENGTH_SHORT).show();
                    }
                });

        // LICENSES
        view.findViewById(R.id.licenses)
                .setOnClickListener(v -> {
                    try
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/techlore/Plexus-app/blob/main/LICENSE")));
                    }
                    // IF BROWSERS NOT INSTALLED, SHOW TOAST
                    catch (ActivityNotFoundException e)
                    {
                        Toast.makeText(requireContext(), getString(R.string.no_browsers), Toast.LENGTH_SHORT).show();
                    }
                });

        // VIEW ON GITHUB
        view.findViewById(R.id.view_on_git)
                .setOnClickListener(v -> {
                    try
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/techlore/Plexus-app/")));
                    }
                    // IF BROWSERS NOT INSTALLED, SHOW TOAST
                    catch (ActivityNotFoundException e)
                    {
                        Toast.makeText(requireContext(), getString(R.string.no_browsers), Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
