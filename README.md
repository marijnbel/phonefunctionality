# phonefunctionality
workshop android phone functionality

Manifest

uses-permission android:name="android.permission.CAMERA"

uses-feature 
  android:name="android.hardware.camera"
  android:required="true"


Activity code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT>22) {
            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {
                // user permission not granted
                // ask permission
                requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);
            } else {
                // user already provided permission
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        flashLight(false);
    }

    @OnClick(R.id.IbtnToggleFlashlight)
    public void toggleFlashlight(){
        flashLight(!isEnabledFlashlight);
    }

    private void flashLight(boolean activate) {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, activate);
            isEnabledFlashlight = activate;
            if(isEnabledFlashlight){
                IbtnToggleFlashlight.setImageResource(R.drawable.torchon);
            } else {
                IbtnToggleFlashlight.setImageResource(R.drawable.torchoff);
            }

        } catch (CameraAccessException e) {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Do nothing if permission is granted
                } else {
                    //User denied
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                        Toast.makeText(this,getString(R.string.permission_denied_needed_torch),Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    //User denied and pressed never ask again
                    else {
                        //Show toast that we can't run this activity without permission and finish it
                        Toast.makeText(this,getString(R.string.permission_denied_required_torch),Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        }
    }
