(function (window, $) {
    if($) {
        var clickableApi = $('#concurrentTest');
        var clickableReset = $('#concurrentTestReset');
        var clickableApiWithoutVersion = $('#concurrentTestWithoutVersion');
        var clickbaleRestWithoutVersion = $('#concurrentTestResetWithoutVersion');

        clickableApi.click(function () {
            var i = 6;
            while(i > 0) {
                $.ajax('/api/trade/user/account/concurrentTest')
                    .done(function (res) {
                        console.log(res);
                    });
                i -= 1;
            }
        });

        clickableApiWithoutVersion.click(function () {
            var i = 6;
            while(i > 0) {
                $.ajax('/api/trade/user/account/concurrentTestWithoutVersion')
                    .done(function (res) {
                        console.log(res);
                    });
                i -= 1;
            }
        });

        clickableReset.click(function () {
            $.ajax('/api/trade/user/account/concurrentTestReset')
                .done(function (res) {
                    console.log(res);
                    window.location.reload();
                });
        });

        clickbaleRestWithoutVersion.click(function () {
            $.ajax('/api/trade/user/account/concurrentTestReset?version=false')
                .done(function (res) {
                    console.log(res);
                    window.location.reload();
                });
        });

    }
})(window, $);