# mock folding feature sample

small sample to demonstrate potential jwm bug

## bug description

Issue: mock folding feature bounds are returned in absolute coordinates, instead of relative coordinates for the current window.

When UI test is run in the left screen, bounds in log statement are:
`TestDebugTag: Rect(672, 0 - 672, 1892)`

https://user-images.githubusercontent.com/33138268/202592569-597875b6-366b-4d75-a6c9-1b198d10e529.mp4

When UI test is run in the right screen, bounds in log statement are:
`TestDebugTag: Rect(2082, 0 - 2082, 1892)`

https://user-images.githubusercontent.com/33138268/202592538-2dd7e557-2227-40f0-bed4-c51c0d2079e6.mp4


## repro steps

1. Open app in left screen
2. Run UI tests - should open automatically in right screen
3. Test will fail due to folding feature bounds - pane size is calculated incorrectly due to absoulute coordinates (expecting relative coordinates)
