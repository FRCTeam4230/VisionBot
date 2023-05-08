# VisionBot
A robot that uses limelight for vision processing. This is meant as an example demonstrating how limelights can be used.

The code is meant to work on the mini-bot with yellow bumpers. If you want to use it on a different robot, you will have to change stuff like the motor controller classes, encoder conversion factors, and so on.

The code uses a custom Limelight class that simplifies Limelight usage, so copy and paste that class into your project if you want to add Limelight using commands to your proejct.

Once you have a Limelight wired to your robot, go to this website to refine some settings
limelight.local:5801

The official documentation for using Limelights can be found here:
https://docs.limelightvision.io/en/latest/getting_started.html#mounting

This code can rotate a robot to follow a piece of retroreflective tape, move forwards and backwards to follow a piece of retroreflective tape, and estimate pose based on april tags.
