# mock folding feature sample

small sample to demonstrate potential jwm bug

## bug description

Issue: mock folding feature bounds are returned in absolute coordinates, instead of relative coordinates for the current window.

When UI test is run in the left screen, bounds in log statement are:
`TestDebugTag: Rect(672, 0 - 672, 1892)`
![video of test passing in left screen](./screenshots/left%20screen.webm)

When UI test is run in the right screen, bounds in log statement are:
`TestDebugTag: Rect(2082, 0 - 2082, 1892)`
![video of test failing in right screen](./screenshots/right%20screen.webm)

## repro steps

1. Open app in left screen
2. Run UI tests - should open automatically in left screen
3. Test will fail due to folding feature bounds - pane size is calculated incorrectly
