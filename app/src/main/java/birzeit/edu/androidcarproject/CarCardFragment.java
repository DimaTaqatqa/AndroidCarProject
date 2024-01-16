package birzeit.edu.androidcarproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CarCardFragment extends Fragment {

    // Define UI elements
    private ImageView carPhoto;
    private TextView carYear, carName, carType, carFactory, carModel, carFuelType,
            carPrice, carOffer, carRating;
    private ImageView favoriteButton;
    private Button reserveButton;

    // Empty constructor is required
    public CarCardFragment() {
    }

    // Create a new instance of the fragment with necessary data
    public static CarCardFragment newInstance() {
        return new CarCardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize UI elements
        carPhoto = view.findViewById(R.id.car_photo);
        carYear = view.findViewById(R.id.car_year);
        carName = view.findViewById(R.id.car_name);
        carType = view.findViewById(R.id.car_type);
        carFactory = view.findViewById(R.id.car_factory);
        carModel = view.findViewById(R.id.car_model);
        carFuelType = view.findViewById(R.id.car_fuel_type);
        carPrice = view.findViewById(R.id.car_price);
        carOffer = view.findViewById(R.id.car_offer);
        carRating = view.findViewById(R.id.car_rating);
        favoriteButton = view.findViewById(R.id.favorite);
        reserveButton = view.findViewById(R.id.reserveButton);

        // Set up click listeners or other interactions as needed

        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle reserve button click
                // You may want to show a dialog or navigate to another screen for reservation
            }
        });

        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("car")) {
            Car car = (Car) arguments.getSerializable("car");

            // Set up the UI elements with data from the Car object
            carName.setText(car.getName());
            carType.setText(car.getType());
            carFactory.setText(car.getFactoryName());
            carModel.setText(car.getModel());
            carFuelType.setText(car.getFuelType());
            carPrice.setText(String.valueOf(car.getPrice()));
            carOffer.setText(String.valueOf(car.getOffer()));
            carRating.setText(String.valueOf(car.getRating()));

            // Load the car photo using an image loading library
            // Example using Picasso: Picasso.get().load(car.getPhotoUrl()).into(carPhoto);
        }
    }
}