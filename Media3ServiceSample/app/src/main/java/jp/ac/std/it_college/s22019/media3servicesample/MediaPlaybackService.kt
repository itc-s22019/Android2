package jp.ac.std.it_college.s22019.media3servicesample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService

class MediaPlaybackService : MediaSessionService() {
    // クライアント(MediaController)と連携するためのコンポーネント
    private var mediaSession: MediaSession? = null
    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession? =
        mediaSession

    // ExoPlayer に設定するイベントリスナ
    // inner class で定義せずに object 式を使って無名クラスとして作る。
    private val playerListener = object : Player.Listener {
        // プレイヤーの再生状態が変化したときに呼ばれるイベントリスナ
        override fun onPlaybackStateChanged(playbackState: Int) {
            // 今回は再生終了(STATE_ENDED)だけ実装。
            when (playbackState) {
                //  再生完了
                Player.STATE_ENDED -> this@MediaPlaybackService.stopSelf()
                // バッファリング中(開始?)
                Player.STATE_BUFFERING -> { }
                // アイドル(待機)状態
                Player.STATE_IDLE -> { }
                // 再生準備完了
                Player.STATE_READY -> { }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        // プレイヤー本体となる ExoPlayer を作る
        val player = ExoPlayer.Builder(this).build()
        //
        player.addListener(playerListener)

        // 作った ExoPlayer を基に MediaSession を作る。
        mediaSession = MediaSession.Builder(this, player).build()
    }

    override fun onDestroy() {
        mediaSession?.run {
            // ExoPlayer のリソース開放
            player.release()

            // MediaSession そのもののリリース開放
            release()
        }
        // MediaSession を破棄
        mediaSession = null
        super.onDestroy()
    }
}
