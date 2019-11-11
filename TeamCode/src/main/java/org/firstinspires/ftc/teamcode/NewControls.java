package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class NewControls extends OpMode {
    private DcMotor frontLeftWheel;
    private DcMotor backLeftWheel;
    private DcMotor frontRightWheel;
    private DcMotor backRightWheel;
    private String log;

    private float frontRightPower;
    private float frontLeftPower;
    private float backRightPower;
    private float backLeftPower;

    private boolean isLB;
    private boolean isRB;
    private boolean isLT;
    private boolean isRT;

    @Override
    public void init() {
        //maps each dcMotor to the corresponding name listed on the "Configure Robot"
        frontLeftWheel = hardwareMap.dcMotor.get("frontLeft");
        backRightWheel = hardwareMap.dcMotor.get("backRight");
        frontRightWheel = hardwareMap.dcMotor.get("frontRight");
        backLeftWheel =  hardwareMap.dcMotor.get("backLeft");

        log = "hardwareMapped";
        telemetry.addData("Output", log);
    }

    @Override
    public void loop(){
        String areYouDumb = "Your fine";
        String areYouDumb2 = "Your fine";
        String presingLT = "No";
        String pressingRT = "No";
        String pressingLB = "No";
        String pressingRB = "No";

        //setting forward and backward movement
        frontRightPower = gamepad1.right_stick_x;
        frontLeftPower = gamepad1.right_stick_x;
        backRightPower = gamepad1.right_stick_x;
        backLeftPower = gamepad1.right_stick_x;

        //finding if buttons are pressed
        isRB = gamepad1.right_bumper;
        isLB = gamepad1.left_bumper;
        //bumpers are used for strafing left and right

        if(isLB && isRB) {
            areYouDumb2 = "Yes";
        } else if(isLB) {
            areYouDumb2 = "No";
            frontRightPower = -frontRightPower;
            frontLeftPower = -frontLeftPower;
        } else if(isRB) {
            areYouDumb2 = "No";
            backLeftPower = - backLeftPower;
            backRightPower = - backRightPower;
        }
    }
}
