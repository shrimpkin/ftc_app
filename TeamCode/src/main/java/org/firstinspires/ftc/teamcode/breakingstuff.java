package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class breakingstuff extends OpMode {
    private DcMotor frontLeftWheel;
    private DcMotor backLeftWheel;
    private DcMotor frontRightWheel;
    private DcMotor backRightWheel;
    private String log;

    private float forwards;
    private float sideways;

    private double velocity;
    private double angle;
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
        //setting forward and side to side movement
        forwards = gamepad1.right_stick_x;
        sideways = gamepad1.right_stick_y;

        velocity = Math.sqrt(Math.pow(forwards,2) + Math.pow(sideways,2));
        angle = Math.atan(sideways/forwards);

        if(velocity >= .1) {
            frontLeftWheel.setPower(Math.sin(angle + Math.PI) * velocity);
            frontRightWheel.setPower(Math.sin(angle - Math.PI) * velocity);
            backLeftWheel.setPower(Math.sin(angle - Math.PI) * velocity);
            backRightWheel.setPower(Math.sin(angle + Math.PI) * velocity);
        }
    }
}
